package myDemo.junit4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Tools.file.FileControl;

public class FileControlTest {
	private static FileControl fileControl = new FileControl() {
	};
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCopyFile() {
		fileControl.copyFile("C:/Users/uigsw/Desktop/工作簿1.xlsx", "C:/Users/uigsw/Desktop/test");
	}

	@Test
	public void testCopyFolder() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerifyPath() {
		fail("Not yet implemented");
	}

}
