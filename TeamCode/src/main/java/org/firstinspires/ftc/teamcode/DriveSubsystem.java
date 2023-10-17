package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DriveSubsystem extends SubsystemBase {
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backLeft;
    private Motor backRight;

    private MecanumDrive drive;

    public DriveSubsystem(final HardwareMap hMap) {
        frontLeft = new Motor(hMap, "frontLeft", Motor.GoBILDA.RPM_312);
        frontRight = new Motor(hMap, "frontRight", Motor.GoBILDA.RPM_312);
        backLeft = new Motor(hMap, "backLeft", Motor.GoBILDA.RPM_312);
        backRight = new Motor(hMap, "backRight", Motor.GoBILDA.RPM_312);

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }

    public void drive(GamepadEx gamepad)
    {
        drive.driveRobotCentric(
                -gamepad.getLeftX(),
                -gamepad.getLeftY(),
                -gamepad.getRightX()
        );
    }

}
