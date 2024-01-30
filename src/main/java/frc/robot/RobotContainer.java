// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.constants.Constants.OperatorConstants;
import frc.constants.Constants.ShuffleboardConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drive;

import org.littletonrobotics.junction.networktables.LoggedDashboardChooser;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  public CommandXboxController driverController = new CommandXboxController(OperatorConstants.driverControllerPort);

  public LoggedDashboardChooser<Command> autoChooser = new LoggedDashboardChooser<>("autoChooser");

  public Drive drive = new Drive();

  public RobotContainer() {
    configureBindings();

    autoChooser.addDefaultOption("nothing", new InstantCommand());
    autoChooser.addOption("say hi", new PrintCommand("hi world"));

    var driveTab = Shuffleboard.getTab(ShuffleboardConstants.driveTab);

    driveTab.add("auto selection", autoChooser.getSendableChooser()).withSize(4, 1);
  }

  private void configureBindings() { 
    
    drive.setDefaultCommand(new TeleopDrive(drive, driverController.getHID()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoChooser.get();
  }
}
