package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FTCRobot extends Robot {
    HardwareMap hardwareMap;
    DriveSubsystem driveSubsystem;

    TeleOpCommand teleOpCommand;

    GamepadEx gamepad;
    public enum OpModeType {
        TELEOP, AUTO
    }

    // the constructor with a specified opmode type
    public FTCRobot(OpModeType type, HardwareMap theHardwareMap, Gamepad theGamepad) {
        hardwareMap = theHardwareMap;
        gamepad = new GamepadEx(theGamepad);
        if (type == OpModeType.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    /*
     * Initialize teleop or autonomous, depending on which is used
     */
    public void initTele() {
        // initialize teleop-specific scheduler
        driveSubsystem = new DriveSubsystem(hardwareMap);
        teleOpCommand = new TeleOpCommand(driveSubsystem, gamepad);
        driveSubsystem.setDefaultCommand(teleOpCommand);
    }

    public void initAuto() {
        // initialize auto-specific scheduler
    }
}
