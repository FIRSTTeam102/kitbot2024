

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;
import frc.robot.constants.DriveConstants;


public class Drive extends SubsystemBase {
  private final WPI_TalonSRX flMotor = new WPI_TalonSRX(DriveConstants.flMotorId);
  private final WPI_TalonSRX blMotor = new WPI_TalonSRX(DriveConstants.blMotorId);
  private final WPI_TalonSRX frMotor = new WPI_TalonSRX(DriveConstants.frMotorId);
  private final WPI_TalonSRX brMotor = new WPI_TalonSRX(DriveConstants.brMotorId);
  //Update Constants.DriveConstants when Id updates 

  private final MecanumDrive drive = new MecanumDrive(flMotor,blMotor,frMotor,brMotor);
  
  public Drive() {
    flMotor.setInverted(false);
    blMotor.setInverted(true);
    frMotor.setInverted(false);
    brMotor.setInverted(true);

  }


  @Override
  public void periodic() {
    updateInputs(inputs);
      Logger.getInstance().processInputs(getName(), inputs);
  }

  public void drive(double xSpeed, double ySpeed, double zRotation){
    drive.driveCartesian(-xSpeed, ySpeed, zRotation);
  }

  @AutoLog
  public static class DriveIOInputs {
    public double flMotorSpeed = 0;
    public double blMotorSpeed = 0;
    public double frMotorSpeed = 0;
    public double brMotorSpeed = 0;
  }
  public DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();

  private void updateInputs(DriveIOInputs inputs) {
    inputs.flMotorSpeed = flMotor.get();
    inputs.blMotorSpeed = blMotor.get();
    inputs.frMotorSpeed = frMotor.get();
    inputs.brMotorSpeed = brMotor.get();
  }

 
}

