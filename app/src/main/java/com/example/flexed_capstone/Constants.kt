package com.example.flexed_capstone

object Constants: java.io.Serializable {
    fun intermediateExerciseList():ArrayList<WorkoutModel>{

        val workoutList = ArrayList<WorkoutModel>()
        val jumpingJacks=WorkoutModel(1,"Jumping Jacks", R.drawable.img_jumping_jacks,false,false)
        val abdominalCrunch=WorkoutModel(2,"Abdominal Crunch",R.drawable.img_abdominal_crunch,false,false)
        val highKneesRunning=WorkoutModel(3,"High Knees Running In Place",R.drawable.img_abdominal_crunch,false,false)
        val plank=WorkoutModel(4,"Plank",R.drawable.img_plank,false,false)
        val pushUp=WorkoutModel(5,"Push Up",R.drawable.img_push_up,false,false)
        val pushUpRotation=WorkoutModel(6,"Push Up And Rotation",R.drawable.img_push_up_and_rotation,false,false)
        val sidePlank=WorkoutModel(7,"Side Plank",R.drawable.img_side_plank,false,false)
        val squat=WorkoutModel(8,"Squat",R.drawable.img_squat,false,false)
        val stepUpChair=WorkoutModel(9,"Step Up Onto Chair",R.drawable.img_step_up_onto_chair,false,false)
        val lunge=WorkoutModel(10,"Lunge",R.drawable.img_lunge,false,false)
        val tricepsDipOnChair=WorkoutModel(11,"Triceps Dip On Chair",R.drawable.img_lunge,false,false)
        val wallSit=WorkoutModel(12,"Wall Sit",R.drawable.img_wall_sit,false,false)

        workoutList.add(jumpingJacks)
        workoutList.add(abdominalCrunch)
        workoutList.add(highKneesRunning)
        workoutList.add(plank)
        workoutList.add(pushUp)
        workoutList.add(pushUpRotation)
        workoutList.add(sidePlank)
        workoutList.add(squat)
        workoutList.add(stepUpChair)
        workoutList.add(lunge)
        workoutList.add(tricepsDipOnChair)
        workoutList.add(wallSit)


        return  workoutList
    }

    fun Advanced():ArrayList<WorkoutModel>{

        val workoutList = ArrayList<WorkoutModel>()
        val backpresses =WorkoutModel(1,"Backpresses", R.drawable.backpresses,false,false)
        val leg_extensions=WorkoutModel(2,"Leg Extensions",R.drawable.leg_extensions,false,false)
        val deadlifts=WorkoutModel(3,"Deadlifts",R.drawable.deadlifts,false,false)
        val bench_presses=WorkoutModel(4,"Bench Presses",R.drawable.bench_presses,false,false)
        val chin_ups=WorkoutModel(5,"Chin Ups",R.drawable.chin_ups,false,false)
        val seated_calf_raises=WorkoutModel(6,"Seated Calf Raises",R.drawable.seated_calf_raises,false,false)
        val diamond_pushu_up_on_bench =WorkoutModel(7,"Diamond Pushup On Bench",R.drawable.diamond_pushup_bench ,false,false)
        val flat_bench_lying_leg_raise=WorkoutModel(8,"Flat Bench Lying Leg Raise",R.drawable.flat_bench_lying_leg_raise,false,false)
        val incline_bench_situp=WorkoutModel(9,"Incline Bench Situp",R.drawable.incline_bench_situp,false,false)
        val seated_jackknife=WorkoutModel(10,"Seated JackKnife ",R.drawable.seated_jackknife,false,false)
        val wrist_curls=WorkoutModel(11,"Wrist Curls",R.drawable.wrist_curls,false,false)
        val parallel_bar_dips=WorkoutModel(12,"Parallel Bar Dips",R.drawable.parallel_bar_dips,false,false)

        workoutList.add(backpresses)
        workoutList.add(leg_extensions)
        workoutList.add(deadlifts)
        workoutList.add(bench_presses)
        workoutList.add(chin_ups)
        workoutList.add(seated_calf_raises)
        workoutList.add(diamond_pushu_up_on_bench )
        workoutList.add(flat_bench_lying_leg_raise)
        workoutList.add(incline_bench_situp)
        workoutList.add(seated_jackknife)
        workoutList.add(wrist_curls)
        workoutList.add(parallel_bar_dips)


        return  workoutList
    }


    fun beginners():ArrayList<WorkoutModel>{


        val workoutList = ArrayList<WorkoutModel>()
        val one_leg_toe_raises=WorkoutModel(1,"One Leg Toe Raise", R.drawable.one_leg_toe_raises,false,false)
        val triceps_kickback=WorkoutModel(2,"Triceps Kickback",R.drawable.triceps_kickback,false,false)
        val dumble_scarecrow=WorkoutModel(3,"Dumble Scarecrow",R.drawable.dumble_scarecrow,false,false)
        val body_weight_superman=WorkoutModel(4,"Body Weight Superman",R.drawable.body_weight_superman,false,false)
        val leg_raises=WorkoutModel(5,"Leg Raise",R.drawable.leg_raises,false,false)
        val crunches=WorkoutModel(6,"Crunches",R.drawable.crunches,false,false)
        val dumbbell_side_bend=WorkoutModel(7,"Dumbbell Side Bend",R.drawable.dumbbell_side_bend,false,false)
        val dumbbell_wrist_twist=WorkoutModel(8,"Squat",R.drawable.dumbbell_wrist_twist,false,false)

        workoutList.add(one_leg_toe_raises)
        workoutList.add(triceps_kickback)
        workoutList.add(dumble_scarecrow)
        workoutList.add(body_weight_superman)
        workoutList.add(leg_raises)
        workoutList.add(crunches)
        workoutList.add(dumbbell_side_bend)
        workoutList.add(dumbbell_wrist_twist)



        return  workoutList
    }
}