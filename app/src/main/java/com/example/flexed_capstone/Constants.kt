package com.example.flexed_capstone

object Constants {
    fun exerciseList():ArrayList<WorkoutModel>{

        val workoutList = ArrayList<WorkoutModel>()
        val jumpingJacks=WorkoutModel(1,"Jumping Jacks", R.drawable.img_jumping_jacks,false,false)
        val abdominalCrunch=WorkoutModel(2,"Abdominal Crunch",R.drawable.img_abdominal_crunch,false,false)
        val highKneesRunnig=WorkoutModel(3,"High Keens Running In Place",R.drawable.img_abdominal_crunch,false,false)
        val plank=WorkoutModel(4,"Plank",R.drawable.img_plank,false,false)
        val pushUp=WorkoutModel(5,"Push Up",R.drawable.img_push_up,false,false)
        val pushUpRotation=WorkoutModel(6,"Push UP And Rotation",R.drawable.img_push_up_and_rotation,false,false)
        val sidePlank=WorkoutModel(7,"Side Plank",R.drawable.img_side_plank,false,false)
        val squat=WorkoutModel(8,"Squat",R.drawable.img_squat,false,false)
        val stepUpChair=WorkoutModel(9,"Step Up Onto Chair",R.drawable.img_step_up_onto_chair,false,false)
        val lunge=WorkoutModel(10,"Lunge",R.drawable.img_lunge,false,false)
        val tricepsDipOnChair=WorkoutModel(11,"Triceps Dip On Chair",R.drawable.img_lunge,false,false)
        val wallSit=WorkoutModel(12,"Wall Sit",R.drawable.img_wall_sit,false,false)

        workoutList.add(jumpingJacks)
        workoutList.add(abdominalCrunch)
        workoutList.add(highKneesRunnig)
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
}