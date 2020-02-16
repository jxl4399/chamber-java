package com.socgen.interview.chamber.service;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChamberServiceTest {

	private static String INPUT_WITHOUT_PARTICLES = null;

	private static String SIMPE_INPUT_RIGHT_ONLY = null;

	private static String COMPLEX_INPUT_RIGHT_ONLY = null;

	private static String SIMPE_INPUT_LEFT_ONLY = null;

	private static String COMPLEX_INPUT_LEFT_ONLY = null;

	private static String SAMPLE_INPUT_1 = null;

	private static String SAMPLE_INPUT_2 = null;

	private static String SAMPLE_INPUT_3 = null;

	private static String SAMPLE_INPUT_5 = null;

	private static List<String> EXPECTED_OUTPUT_FROM_INPUT_WITHOUT_PARTICLES = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_5 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_5 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_3_SPEED_10 = new ArrayList<>();

	private static List<String> EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1 = new ArrayList<>();

	@Autowired
	private ChamberService chamberService;

	@BeforeAll
	public static void init() {
		INPUT_WITHOUT_PARTICLES = ".....";
		SIMPE_INPUT_RIGHT_ONLY = "..R....";
		COMPLEX_INPUT_RIGHT_ONLY = "..R..R.";
		SIMPE_INPUT_LEFT_ONLY = "....L..";
		COMPLEX_INPUT_LEFT_ONLY = ".L..L..";
		SAMPLE_INPUT_1 = "RR..LRL";
		SAMPLE_INPUT_2 = "LRLR.LRLR";
		SAMPLE_INPUT_3 = "RLRLRLRLRL";
		SAMPLE_INPUT_5 = "LRRL.LR.LRR.R.LRRL.";

		EXPECTED_OUTPUT_FROM_INPUT_WITHOUT_PARTICLES.add(INPUT_WITHOUT_PARTICLES);

		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.add("..X....");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.add("...X...");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.add("....X..");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.add(".....X.");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.add("......X");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.add(".......");

		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2.add("..X....");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2.add("....X..");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2.add("......X");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2.add(".......");

		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_5.add("..X....");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_5.add(".......");

		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.add("..X..X.");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.add("...X..X");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.add("....X..");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.add(".....X.");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.add("......X");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.add(".......");

		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.add("....X..");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.add("...X...");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.add("..X....");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.add(".X.....");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.add("X......");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.add(".......");

		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2.add("....X..");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2.add("..X....");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2.add("X......");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2.add(".......");

		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_5.add("....X..");
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_5.add(".......");

		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.add(".X..X..");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.add("X..X...");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.add("..X....");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.add(".X.....");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.add("X......");
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.add(".......");

		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3.add("XX..XXX");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3.add(".X.XX..");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3.add("X.....X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3.add(".......");

		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2.add("XXXX.XXXX");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2.add("X..X.X..X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2.add(".X.X.X.X.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2.add(".X.....X.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2.add(".........");

		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_3_SPEED_10.add("XXXXXXXXXX");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_3_SPEED_10.add("..........");

		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("XXXX.XX.XXX.X.XXXX.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("..XXX..X..XX.X..XX.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add(".X.XX.X.X..XX.XX.XX");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("X.X.XX...X.XXXXX..X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add(".X..XXX...X..XX.X..");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("X..X..XX.X.XX.XX.X.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("..X....XX..XX..XX.X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add(".X.....XXXX..X..XX.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("X.....X..XX...X..XX");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add(".....X..X.XX...X..X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("....X..X...XX...X..");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("...X..X.....XX...X.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("..X..X.......XX...X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add(".X..X.........XX...");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("X..X...........XX..");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("..X.............XX.");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add(".X...............XX");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("X.................X");
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.add("...................");

	}

	@AfterAll
	public static void clear() {
		INPUT_WITHOUT_PARTICLES = null;
		SIMPE_INPUT_RIGHT_ONLY = null;
		COMPLEX_INPUT_RIGHT_ONLY = null;
		SIMPE_INPUT_LEFT_ONLY = null;
		COMPLEX_INPUT_LEFT_ONLY = null;
		SAMPLE_INPUT_1 = null;
		SAMPLE_INPUT_2 = null;
		SAMPLE_INPUT_3 = null;
		SAMPLE_INPUT_5 = null;
		
		EXPECTED_OUTPUT_FROM_INPUT_WITHOUT_PARTICLES.clear();
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1.clear();
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2.clear();
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_5.clear();
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1.clear();
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1.clear();
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2.clear();
		EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_5.clear();
		EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1.clear();
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3.clear();
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2.clear();
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_3_SPEED_10.clear();
		EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1.clear();
	}

	@Test
	public void givenInput_whenNoParticles_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(2, INPUT_WITHOUT_PARTICLES);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_INPUT_WITHOUT_PARTICLES, actualLines);
	}

	@Test
	public void givenInput_whenSingleRightMovingParticleAndSpeed_1_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(1, SIMPE_INPUT_RIGHT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_1, actualLines);
	}

	@Test
	public void givenInput_whenSingleRightMovingParticleAndSpeed_2_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(2, SIMPE_INPUT_RIGHT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_2, actualLines);
	}

	@Test
	public void givenInput_whenSingleRightMovingParticleAndSpeed_4_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(5, SIMPE_INPUT_RIGHT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_RIGHT_ONLY_SPEED_5, actualLines);
	}

	@Test
	public void givenInput_whenSingleLeftMovingParticleAndSpeed_1_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(1, SIMPE_INPUT_LEFT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_1, actualLines);
	}

	@Test
	public void givenInput_whenSingleLeftMovingParticleAndSpeed_2_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(2, SIMPE_INPUT_LEFT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_2, actualLines);
	}

	@Test
	public void givenInput_whenSingleLeftMovingParticleAndSpeed_4_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(5, SIMPE_INPUT_LEFT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SIMPLE_INPUT_LEFT_ONLY_SPEED_5, actualLines);
	}

	@Test
	public void givenInput_whenTwoRightMovingParticleAndSpeed_1_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(1, COMPLEX_INPUT_RIGHT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_RIGHT_ONLY_SPEED_1, actualLines);
	}

	@Test
	public void givenInput_whenTwoLeftMovingParticleAndSpeed_1_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(1, COMPLEX_INPUT_LEFT_ONLY);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_COMPLEX_INPUT_LEFT_ONLY_SPEED_1, actualLines);
	}

	@Test
	public void givenInput_whenSampleInput_1AndSpeed_3_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(3, SAMPLE_INPUT_1);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_1_SPEED_3, actualLines);
	}

	@Test
	public void givenInput_whenSampleInput_2AndSpeed_2_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(2, SAMPLE_INPUT_2);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_2_SPEED_2, actualLines);
	}

	@Test
	public void givenInput_whenSampleInput_3AndSpeed_10_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(10, SAMPLE_INPUT_3);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_3_SPEED_10, actualLines);
	}

	@Test
	public void givenInput_whenSampleInput_5AndSpeed_1_thenReturnCorrectResult() {
		List<String> actualLines = chamberService.animate(1, SAMPLE_INPUT_5);
		assertLinesMatch(EXPECTED_OUTPUT_FROM_SAMPLE_INPUT_5_SPEED_1, actualLines);
	}
}
