package com.socgen.interview.chamber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChamberServiceImpl implements ChamberService {

	private static final String RIGHT = "R";
	private static final String LEFT = "L";
	private static final String DOT = ".";
	private static final String OCCUPIED = "X";

	public List<String> animate(int speed, String init) {
		int length = init.length();
		String[] rightForward = new String[length];
		String[] leftForward = new String[length];
		int rightLow = -1, rightHigh = -1, leftLow = length, leftHigh = length;

		for (int i = 0; i < length; i++) {
			String s = init.substring(i, i + 1);
			if (DOT.equals(s)) {
				rightForward[i] = DOT;
				leftForward[i] = DOT;
			} else if (RIGHT.equals(s)) {
				leftForward[i] = DOT;
				rightForward[i] = RIGHT;
				if (rightLow < 0) {
					rightLow = i;
					rightHigh = i;
				} else {
					rightHigh = i;
				}
			} else {
				rightForward[i] = DOT;
				leftForward[i] = LEFT;
				if (leftLow == length) {
					leftLow = i;
					leftHigh = i;
				} else {
					leftHigh = i;
				}
			}
		}

		List<String> ret = new ArrayList<>();
		String start = init.replace(RIGHT, OCCUPIED).replace(LEFT, OCCUPIED);
		ret.add(start);

		startAnimate(speed, length, rightForward, leftForward, rightLow, rightHigh, leftLow, leftHigh, ret);

		return ret;
	}

	private void startAnimate(int speed, int length, String[] rightForward, String[] leftForward, int rightLow,
			int rightHigh, int leftLow, int leftHigh, List<String> ret) {
		while (!isChamberCleared(rightLow, rightHigh, leftLow, leftHigh, length)) {
			if (!isRightForwardCleared(rightLow, rightHigh, length)) {
				moveRight(speed, length, rightForward, rightLow, rightHigh);
				rightLow = rightLow + speed;
				rightHigh = rightHigh + speed;
			}
			if (!isLeftForwardCleared(leftLow, leftHigh, length)) {
				moveLeft(speed, leftForward, leftLow, leftHigh);
				leftLow = leftLow - speed;
				leftHigh = leftHigh - speed;
			}
			String chamberSnapShot = getChamberSnapShot(length, rightForward, leftForward);
			ret.add(chamberSnapShot);
		}
	}

	private String getChamberSnapShot(int length, String[] rightForward, String[] leftForward) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			if (rightForward[i] != leftForward[i]) {
				buffer.append(OCCUPIED);
			} else {
				buffer.append(DOT);
			}
		}
		return buffer.toString();
	}

	private void moveLeft(int speed, String[] leftForward, int leftLow, int leftHigh) {
		int currentLeftHigh = leftHigh - speed;
		if (currentLeftHigh < 0) {
			moveLeftOutBound(leftForward, leftHigh);
		} else {
			moveLeftInBound(speed, leftForward, leftLow, leftHigh);
		}
	}

	private void moveLeftInBound(int speed, String[] leftForward, int leftLow, int leftHigh) {
		for (int i = leftLow; i <= leftHigh; i++) {
			if (i >= 0 && leftForward[i].equals(LEFT)) {
				if ((i - speed) >= 0) {
					leftForward[i - speed] = leftForward[i];
				}
				leftForward[i] = DOT;
			}
		}
	}

	private void moveLeftOutBound(String[] leftForward, int leftHigh) {
		for (int i = leftHigh; i >= 0; i--) {
			leftForward[i] = DOT;
		}
	}

	private void moveRight(int speed, int length, String[] rightForward, int rightLow, int rightHigh) {
		int currentRightLow = rightLow + speed;
		if (currentRightLow >= length) {
			moveRightOutBound(length, rightForward, rightLow);
		} else {
			moveRightInBound(speed, length, rightForward, rightLow, rightHigh);
		}
	}

	private void moveRightInBound(int speed, int length, String[] rightForward, int rightLow, int rightHigh) {
		for (int i = rightHigh; i >= rightLow; i--) {
			if (i < length && rightForward[i].equals(RIGHT)) {
				if ((i + speed) < length) {
					rightForward[i + speed] = rightForward[i];
				}
				rightForward[i] = DOT;
			}
		}
	}

	private void moveRightOutBound(int length, String[] rightForward, int rightLow) {
		for (int i = rightLow; i < length; i++) {
			rightForward[i] = DOT;
		}
	}

	private boolean isChamberCleared(int rightLow, int rightHigh, int leftLow, int leftHigh, int totalLength) {
		return isRightForwardCleared(rightLow, rightHigh, totalLength)
				&& isLeftForwardCleared(leftLow, leftHigh, totalLength);
	}

	private boolean isRightForwardCleared(int rightLow, int rightHigh, int totalLength) {
		return (rightLow < 0 && rightHigh < 0) || (rightLow >= totalLength);
	}

	private boolean isLeftForwardCleared(int leftLow, int leftHigh, int totalLength) {
		return (leftLow == totalLength && leftHigh == totalLength) || (leftHigh < 0);
	}
}
