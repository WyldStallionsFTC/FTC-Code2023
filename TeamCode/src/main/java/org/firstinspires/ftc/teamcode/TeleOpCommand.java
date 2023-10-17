package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

public class TeleOpCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final GamepadEx gamepad;

    public TeleOpCommand(DriveSubsystem drive, GamepadEx theGamePad)
    {
        driveSubsystem = drive;
        gamepad = theGamePad;
        addRequirements(drive);
    }

    @Override
    public void execute()
    {
        driveSubsystem.drive(gamepad);
    }
}
