;;; Sierra Script 1.0 - (do not remove this comment)
(script# 110)
(include sci.sh)
(include Verbs.sh)
(include game.sh)
(include 110.shm)
(include 110.shp)
(use Main)
(use DisposeLoad)
(use Sound)
(use Cycle)
(use Game)
(use Actor)
(use System)
(use Print)
(use Polygon)
(use ScaleTo)
(use StopWalk)
(use Chase)
(use PFollow)
(use User)


(public
	rm110 0
)

(local
	dead
)

(instance gunSound of Sound
	(properties
		number 187 
		priority 1
		flags 1
	)
)

(instance screamSound of Sound
	(properties
		number 1 
		priority 1
		flags 1
	)
)



(instance guy of Actor
	(properties
        view 110
        x 231
        y 150
        signal ignAct
        noun N_GUY
    )
    
	(method (doVerb theVerb)
		(switch theVerb
			(V_LOOK
				(if (not (Btest F_GuyDead))
       		 		(gunSound play:)
					(Bset F_GuyDead)
					(AddToScore 100)
					(guy setCycle: EndLoop)
				)
       		)
       		(else
           		 (super doVerb: theVerb &rest)
			)
   		)
	)
)

(instance hobo of Actor
	(properties
        view 113
        y 131
        signal ignAct
        noun N_HOBO
    )
    
    (method (doVerb theVerb)
		(switch theVerb
			(V_LOOK
				(if (not (Btest F_HoboDead))
        			(gunSound play:)
        			(Bset F_HoboDead)
        			(hobo 
        				view: 114
        				setCycle: EndLoop
        			)	
					(AddToScore 100)
				)
			)
        	(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sonny of Actor
	(properties
        view 666
        x -15
        y 160
        signal ignAct
        noun N_SONNY
    )
    
    (method (doVerb theVerb)
    	(switch theVerb
        	(V_LOOK
        		;(Prints {Don't shoot Sonny Bonds, Please. -10 points})
        		(if (not (Btest F_sonnyDead))
        			(AddToScore -10)
        			(gunSound play:)
        			(sonny setScript: sonnyDeathScript)
				)
       		)
        	(else
            	(super doVerb: theVerb &rest)
       		)
    	)
	)
)

(instance marie of Actor
	(properties
        view 116
        x -45
        y 160
        signal ignAct
        noun N_MARIE
    )
    
    (method (doVerb theVerb)
    	(switch theVerb
        	(V_LOOK
        		;(Prints {Don't shoot Marie! -10 points})
        		(if (not (Btest F_marieDead))
        			(gunSound play:)
        			(AddToScore -10)
        			(marie setScript: marieDeathScript)
				)
       		)
        	(else
            	(super doVerb: theVerb &rest)
       		)
    	)
	)
)


(instance cedric of Actor
	(properties
        view 112
        x 0
        y -15
        signal ignAct
        noun N_CEDRIC
    )
    
    (method (doVerb theVerb)
    	(switch theVerb
        	(V_LOOK
        		(if (not (Btest F_CedricDead))
        			(Bset F_CedricDead)
        			(cedric setMotion: 0)
        			(cedricScript changeState: 66)
        			(gunSound play:)
        			(AddToScore 50)
				)
       		)
        	(else
            	(super doVerb: theVerb &rest)
       		)
    	)
	)
)

(instance roll of Actor
	(properties
        view 115
        x -100
        y 190
        signal ignAct
        noun N_ROLL
    )
    
    (method (doVerb theVerb)
    	(switch theVerb
        	(V_LOOK
        		(if (not (Btest F_rollDead))
        			(Bset F_rollDead)
       		 		(roll setMotion: 0)
       		 		(rollScript changeState: 66)
        			(gunSound play:)
        			(AddToScore 150)
				)
       		)
        	(else
            	(super doVerb: theVerb &rest)
       		)
    	)
	)
)

(instance rm110 of Room
	(properties
		picture 110
		style (| dpANIMATION_BLACKOUT dpOPEN_FADEPALETTE)
		horizon 50
		vanishingX 130
		vanishingY 50
		noun N_ROOM
	)
	
	(method (init)
		(AddPolygonsToRoom @P_Default110)
		(super init:)
		(Bclear F_CedricDead)
		(Bclear F_GuyDead)
		(Bclear F_HoboDead)
		(Bclear F_rollDead)
		
		(switch gPreviousRoomNumber
			; Add room numbers here to set up the ego when coming from different directions.
;;;			(else 
;;;				(SetUpEgo -1 1)
;;;				(gEgo posn: 150 130)
;;;			)
		)
;;;		(gEgo init:)
		; We just came from the title screen, so we need to call this to give control
		; to the player.
		(guy init:)
		(hobo 
			setCycle: Forward
			x: (Random 80 140)
			setScale: scaleX: 100 scaleY: 100
			moveSpeed: 20
			cycleSpeed: 20
			init:
		)
		(cedric
			ignoreHorizon:
			ignoreControl:
			setStep: 5 3
			setCycle: StopWalk -1
			setScript: cedricScript
			init:
		)
		(roll
			ignoreHorizon:
			ignoreControl:
			setScript: rollScript
			moveSpeed: 20
			cycleSpeed: 20
			init:
		)
		(sonny 
			ignoreHorizon:
			setCycle: StopWalk
			setMotion: MoveTo 420 160 
			moveSpeed: 20
			cycleSpeed: 20
			setScale: ScaleTo 200
			init:
			
		)
		(marie
			ignoreHorizon:
			setCycle: StopWalk
			setMotion: MoveTo 420 160 
			moveSpeed: 20
			cycleSpeed: 20
			;setScale: ScaleTo 200
			init:
			
		)
		;(gEgo hide: true)
		(gGame handsOn:)
	)
	
	(method (doit)
        (super doit:)
        (if 
     		(and
     			(not (Btest F_marieDead))
       			(<= (guy distanceTo: marie) 25)
       			(not (Btest F_GuyDead))
			)
            (marie setScript: marieDeathScript)
        )
        (if
        	(and
        		(not (Btest F_marieDead))
        		(<= (cedric distanceTo: marie) 20)
        		(not (Btest F_CedricDead))
			)
        	(marie setScript: marieDeathScript)
        	(cedricScript changeState: 66)
		)
        (if 
        	(and
        		(<= (guy distanceTo: sonny) 25)
        		(not (Btest F_GuyDead))
        		(not (Btest F_sonnyDead))
			)
            (sonny setScript: sonnyDeathScript)
        )
        (if 
        	(and
        		(not (Btest F_sonnyDead))
        		(<= (cedric distanceTo: sonny) 20)
        		(not (Btest F_CedricDead))
			)
        	(sonny setScript: sonnyDeathScript)
        	(cedricScript changeState: 66)
		)
        (if (>= (sonny x?) 330)
        	(AddToScore 200)
        	(Bset F_sonnyClear)
        	(sonny
        		setMotion: 0
        		x: 10
        		hide:
        		dispose:
        	)
		)
        (if (>= (marie x?) 330)
        	(AddToScore 500)
        	(Bset F_marieClear)
        	(marie
        		setMotion: 0 
        		x:10
        		dispose:
        	)
		)
		(if
			(and
				(Btest F_sonnyDead)
				(Btest F_marieDead)
				(== dead 0)
			)
			(= dead 1)
			(self setScript: delayDeathScript)
		)
		(if 
			(or
				(and
					(Btest F_sonnyDead)
					(Btest F_marieClear)
				)
				(and
					(Btest F_marieDead)
					(Btest F_sonnyClear)
				)
				(and
					(Btest F_sonnyClear)
					(Btest F_marieClear)
				)
			)
			(gRoom newRoom: 112)
		)
    )
)

(instance cedricScript of Script
    (properties)

    (method (doit)
        (super doit:)
    )
    
   	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric
					x: (Random 10 320)
					y: -15
				)
				(= cycles 1)
			)
			(1
				(= seconds (Random 1 2)) ;was 5 10
			)
			(2
				(Bclear F_CedricDead)
				(switch TRUE
					(;no target
						(and
							(or 
								(Btest F_sonnyClear)
								(Btest F_sonnyDead)	
							)
							(or 
								(Btest F_marieClear)
								(Btest F_marieDead)	
							)
						)
						(cedric setCycle: StopWalk setMotion: MoveTo (Random 10 310) (Random 10 140) self)
						(= state 1)
					)
					(;sonny gone
						(or
							(Btest F_sonnyDead)
							(Btest F_sonnyClear)
						)
						(cedric setMotion: MoveTo (+ (marie x?) (Random 0 100)) (- (marie y?) 15) self)
						(= state 30)
					)
					(;marie gone
						(or
							(Btest F_marieDead)
							(Btest F_marieClear)
						)
						(cedric setMotion: MoveTo (+ (sonny x?) (Random 0 100)) (- (sonny y?) 15) self)
						(= state 20)
					)		
					(else ;either available
						(if (>= 20 (Random 0 50))
							(cedric setMotion: MoveTo (sonny x?) (- (sonny y?) 15) self)
							(= state 20)
						else
							(cedric setMotion: MoveTo (marie x?) (- (marie y?) 15) self)
							(= state 30)
						)
					)
				)
			)
			(21
				(if
					(or
						(Btest F_sonnyDead)
						(Btest F_sonnyClear)
					)
					(cedric setMotion: MoveTo (sonny x?) (- (sonny y?) 15) self)
					(= state 20)
				else 
					(= state 1)
					(= cycles 1)
				)
			)
			(31
				(if
					(or
						(Btest F_marieDead)
						(Btest F_marieClear)
					)
					(cedric setMotion: MoveTo (marie x?) (- (marie y?) 15) self)
					(= state 30)
				else 
					(= state 1)
					(= cycles 1)
				)	
			)
			(66
				(cedric loop: 4 setCycle: EndLoop self)
			)
			(67
				(cedric
					;loop: 0
					setCycle: StopWalk ;Forward
					x: (Random 10 320)
					y: -15
				)
				(= state 1)
				(= cycles 1)
			)
		)
	)
)

(instance rollScript of Script
    (properties)

    (method (doit)
        (super doit:)

    )
    
   	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(roll
					x: (- (sonny x?) 10)
					setCycle: EndLoop self
				)
			)
			
			(2
				(roll
					loop: 1
					;y: (- (sonny y?) 10)
					setCycle: EndLoop
				)
			)
;;;			(3
;;;				(roll
;;;					loop: 1
;;;					setCycle: EndLoop self
;;;				)
;;;			)
			(66
				(roll
					loop: 3
					cel: 0
					setCycle: EndLoop
				)
			)
		)
	)
)

(instance sonnyDeathScript of Script
    (properties)

    (method (doit)
        (super doit:)

    )
    
   	(method (changeState newState)
		(switch (= state newState)
			(0
				(Bset F_sonnyDead)
				(sonny
					setMotion: 0
					setLoop: 1
					setCel: 0
					setCycle: EndLoop self)
			)
			(1
				(sonny dispose:)
			)
		)
	)
)

(instance marieDeathScript of Script
    (properties)

    (method (doit)
        (super doit:)

    )
    
   	(method (changeState newState)
		(switch (= state newState)
			(0
				(Bset F_marieDead)
				(screamSound play:)
				(marie
					setMotion: 0
					setLoop: 1
					setCel: 0
					setCycle: EndLoop self)
			)
			(1
				(marie dispose:)
			)
		)
	)
)

(instance delayDeathScript of Script
    (properties)

    (method (doit)
        (super doit:)

    )
    
   	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(Die)
			)
		)
	)
)