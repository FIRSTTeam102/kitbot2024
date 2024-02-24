// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.PassNote;
import frc.robot.commands.StartShooter;
import frc.robot.commands.StopShooter;
import frc.robot.constants.ShooterConstants.*;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Shoot extends SequentialCommandGroup {
  private shooter Shooter;
  public Shoot(shooter shooter) {
    addRequirements(shooter);
    this.Shooter = shooter;
    addCommands(
      new StartShooter(shooter),
      new PassNote(shooter),
      // set timer
      new StopShooter(shooter)
    );
  }
}

