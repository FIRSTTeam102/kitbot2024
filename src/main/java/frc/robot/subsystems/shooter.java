// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import static frc.robot.constants.ShooterConstants.*;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

public class shooter extends SubsystemBase {
  private TalonSRX ShooterMotor = new TalonSRX(ShooterMotorID);
  private TalonSRX HolderMotor = new TalonSRX(HolderMotorID);
  
  public shooter() {
    ShooterMotor.setInverted(false);
    HolderMotor.setInverted(false);

  }

  public void setShooterMotorSpeed(double MotorSpeed) {
    ShooterMotor.set(ControlMode.PercentOutput,MotorSpeed);
  }

  public void setHolderMotorSpeed(double MotorSpeed) {
    HolderMotor.set(ControlMode.PercentOutput,MotorSpeed);
  }

  public void stopShooterMotor() {
    ShooterMotor.set(ControlMode.PercentOutput,0);
  }

  public void stopHolderMotor() {
    HolderMotor.set(ControlMode.PercentOutput,0);
  }

  @Override
  public void periodic() {
    updateInputs(inputs);
    Logger.processInputs(getName(), inputs);
  }
  // TODO 
  @AutoLog
	public static class shooterIOInputs {
		public double ShooterMotorPercentOutput = 0.0;
    public double HolderMotorPercentOutput = 0.0;
		public double ShooterMotorCurrent_A = 0.0;
    public double HolderMotorCurrent_A = 0.0;
		public double ShooterMotorTemperature_C = 0.0;
    public double HolderMotorTemperature_C = 0.0;
	}

	public shooterIOInputsAutoLogged inputs = new shooterIOInputsAutoLogged();

	private void updateInputs(shooterIOInputs inputs) {
		//inputs.ShooterMotorPercentOutput = Robot.isReal() ? ShooterMotor.getAppliedOutput() : ShooterMotor.get();
		inputs.ShooterMotorCurrent_A = ShooterMotor.getSupplyCurrent();
		inputs.ShooterMotorTemperature_C = ShooterMotor.getTemperature();
    //inputs.HolderMotorPercentOutput = Robot.isReal() ? HolderMotor.getAppliedOutput(): HolderMotor.get();
		inputs.HolderMotorCurrent_A = HolderMotor.getSupplyCurrent();
		inputs.HolderMotorTemperature_C = HolderMotor.getTemperature();
	}
}
