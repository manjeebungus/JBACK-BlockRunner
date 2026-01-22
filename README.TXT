______________________________________________________________________________________________________________________
  _______   __       ______   ______   ___   ___      ______    __  __   ___   __    ___   __    ______   ______       
/_______/\ /_/\     /_____/\ /_____/\ /___/\/__/\    /_____/\  /_/\/_/\ /__/\ /__/\ /__/\ /__/\ /_____/\ /_____/\      
\::: _  \ \\:\ \    \:::_ \ \\:::__\/ \::.\ \\ \ \   \:::_ \ \ \:\ \:\ \\::\_\\  \ \\::\_\\  \ \\::::_\/_\:::_ \ \     
 \::(_)  \/_\:\ \    \:\ \ \ \\:\ \  __\:: \/_) \ \   \:(_) ) )_\:\ \:\ \\:. `-\  \ \\:. `-\  \ \\:\/___/\\:(_) ) )_   
  \::  _  \ \\:\ \____\:\ \ \ \\:\ \/_/\\:. __  ( (    \: __ `\ \\:\ \:\ \\:. _    \ \\:. _    \ \\::___\/_\: __ `\ \  
   \::(_)  \ \\:\/___/\\:\_\ \ \\:\_\ \ \\: \ )  \ \    \ \ `\ \ \\:\_\:\ \\. \`-\  \ \\. \`-\  \ \\:\____/\\ \ `\ \ \ 
    \_______\/ \_____\/ \_____\/ \_____\/ \__\/\__\/     \_\/ \_\/ \_____\/ \__\/ \__\/ \__\/ \__\/ \_____\/ \_\/ \_\/ 
                                                                                                                       
______________________________________________________________________________________________________________________

Title:                      Block Runner
Authors:                    Chase Coulter, Kelton Kuan, Abithan Paskaranathan, Josh Ye, Brian Cheung
Date of Writing:            2026/01/20
Purpose of Project:         This is a 2d sidescrolling platformer based off the popular game, "Geometry Dash"
			    The levels are based on square grids, contained in a 2d array, as the project requires
How to start this Project:  Open Project.Greenfoot File with the Greenfoot Game Engine, press the 
                            "run" button on the lower margin
User Instructions:          Click the Center Button to enter level select, select a level and begin playing
Block Comment:				The player can jump using space, which can also be used to activate the orb, launching 
							you the same height as a player jump. Other objects, such as pads, will launch you without
							the need of any keys any and portals will change your modes to either cube or ship. The ship
							can fly by holding or tapping space. All player modes are affected by gravity and will get 
							"pulled" back down. Our grid was used for our actual levels, which lay out all of our 
							obstacles/objects for that level. When in the settings menu, the user can adjust the volumes
							of the music and of the sound effects with the plus and minus buttons. These volumes are stored
							in a text file "data.txt" including the player name and number of attempts.

Credits:
	Chase Coulter:
			All Visual Artwork and Particle Effects, Initial Idea/Creative Vision for Project Visual, CirclePulse, 
			Particle, ScreenWipe, StaticImage, Menu, LevelSelectScreen, 
			StartScreen, Button, Ground,Util, (Assisted)Cube, (Assisted)ScrollWorld, ReadMe File
		
	Kelton Kuan:
			ScrollWorld (All except visuals and hitbox code), SettingsScreen, Sound (All code and template for subclass),SettingsButton,
			Player (Tile and ground collision code including checkSolid method, Player death and reset code, assisted with player movement),
			Cube (Assisted with jumping logic), WorldObject (All except hitbox interactions), Ground (Assisted with logic),
			Spike (All except hitboxes), Spike1 (All except image), Spike2(All except image), Spike3 (All except image),
			Tile (All except hitbox renderer), Block1 (All except image), Block2 (All except image), Block3 (All except image),
			Levels (Implemented id system and created the template to create levels, did not actually make the levels), UserData
			
		
	Abithan Paskaranathan:
			Created classes Player (with assistance from Kelton. Added help methods, added to case INTERACT AND HAZARD, 
			constuctor and some act code), Cube, Ship, Orb, JumpOrb, Portal, Cube portal, Ship portal. 
			Portals have a hitbox type of INTERACT, which is dealt with by my checkInteraction method in the player
			Added and implemented sounds found by Josh Ye. Ex. Sound for Level 1,2,3, level complete, cube crash, homeScreen 
			and level select screen. Code for the level select screen sound to work was added to the Screen Change button, 
			ScrollWorld and Player. Added additional obstacles to levels 1 and 2, and redid and improved level 3 a lot.
		
	Josh Ye:
All level creations, sound effects, all sound classes, class diagram
Credits for sounds:
level1.mp3 credit to genesis by grimes
level2.mp3 credit to feel good by syn cole
level.mp3 credit to ocean drive by duke dumont
buttonpress.wav credit to from zapsplat(used in Binding of Issac)
cubecrashing.wav credit to robtop
homescreen.mp3 credit to electric by alina baraz and khalid
levelcompleted.wav credit to mixkit
	Brian Cheung:
		-Hitbox class, which handles collisions as well as 				adjustable x/y values and offsets
		-Assisted in the creation of portals and orbs
		-Created jump pads
		-Person who looks for and edits level errors
		-Hitbox renderer, which is essential for testing and 			balancing
      
