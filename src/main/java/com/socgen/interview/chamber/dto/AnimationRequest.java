package com.socgen.interview.chamber.dto;

import java.io.Serializable;


public class AnimationRequest implements Serializable {
	
	private static final long serialVersionUID = -8629822530975652869L;
	
	private int speed;
	
	private String init;
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((init == null) ? 0 : init.hashCode());
		result = prime * result + speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimationRequest other = (AnimationRequest) obj;
		if (init == null) {
			if (other.init != null)
				return false;
		} else if (!init.equals(other.init))
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}


}
