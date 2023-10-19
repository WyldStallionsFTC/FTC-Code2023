package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

public class LiftUpCommand extends CommandBase {
    EndEffectorSubsystem endEffectorSubsystem;
    boolean finished = true;

    public void LiftUpCommand(EndEffectorSubsystem endEffectorSubsystem)
    {
        this.endEffectorSubsystem = endEffectorSubsystem;
        addRequirements(endEffectorSubsystem);
    }

    @Override
    public void initialize()
    {
        finished = false;
        while (!endEffectorSubsystem.isFinished())
        {
            endEffectorSubsystem.liftUp(1200);
        }
        finished = true;
    }

    @Override
    public boolean isFinished()
    {
        return finished;
    }
}
