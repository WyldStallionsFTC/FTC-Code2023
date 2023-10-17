package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "FTCTeleOp", group = "")
public class FTCTeleOp extends CommandOpMode  {
    FTCRobot robot;

    @Override
    public void initialize()
    {
        robot = new FTCRobot(FTCRobot.OpModeType.TELEOP, hardwareMap, gamepad1);
    }
}
