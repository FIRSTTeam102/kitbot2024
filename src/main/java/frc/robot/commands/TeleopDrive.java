
package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;



public class TeleopDrive extends Command {
  private Drive drive;
  private XboxController controller; 




  public TeleopDrive(Drive drive, XboxController controller) {
    addRequirements(drive);
    this.drive = drive;
    this.controller = controller; 
  }

  
  @Override
  public void initialize() {}

 
  @Override
  public void execute() {
    drive.drive(inputCurve(-controller.getLeftX()),
            inputCurve(-controller.getLeftY()),
            inputCurve(-controller.getRightX()));
  }
 
  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }

  public double inputCurve(double input){
    return MathUtil.applyDeadband(Math.copySign(Math.pow (input , 2), input),0.05);
  }
}
