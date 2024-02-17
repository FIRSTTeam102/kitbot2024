package frc.robot.constants;

public final class Constants {
    public static final RobotMode robotMode = RobotMode.Active;

    public enum RobotMode {
        Active, Replay;
    }

    public static class OperatorConstants {
        public static final int driverControllerPort = 0;
    }
    
    public static class ShuffleboardConstants {
		public static final String driveTab = "drive";
	}
}
