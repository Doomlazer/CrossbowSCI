;;; Sierra Script 1.0 - (do not remove this comment)
(script# 111)
(include sci.sh)
(include Verbs.sh)
(include game.sh)
(include 111.shm)
(include 111.shp)
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

(instance gunSound of Sound
	(properties
		number 187 
		priority 1
		flags 1
	)
)


(instance guy of Actor
	(properties
        view 110
        x 231
        y 145
        signal ignAct
        noun N_GUY
    )
    
    (method (doVerb theVerb)
    (switch theVerb
        (V_LOOK
        	(gunSound play:)
			;(Prints {FUCK! ME!})
			(Bset F_GuyDead)
			(AddToScore 100)
			
			(guy
				setCycle: EndLoop
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
        y 111
        signal ignAct
        noun N_HOBO
    )
    
    (method (doVerb theVerb)
    (switch theVerb
        (V_LOOK
        	(gunSound play:)
        	(hobo 
        		view: 114
        		setCycle: EndLoop
        	)	
			(AddToScore 100)
        )
        (else
            (super doVerb: theVerb &rest)
        )
    )
    
	)
)

(instance ghram of Actor
	(properties
        view 117
        x 140
        y 130
        signal ignAct
        noun N_GHRAM
    )
    
    (method (doVerb theVerb)
    	(switch theVerb
        	(V_LOOK
        		(Prints {Don't shoot king Ghram, Please.})
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
        		(cedric setMotion: 0)
        		(cedricScript changeState: 66)
        		(gunSound play:)
        		(AddToScore 50)
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
        		(roll setMotion: 0)
        		(rollScript changeState: 66)
        		(gunSound play:)
        		(AddToScore 150)
       		)
        	(else
            	(super doVerb: theVerb &rest)
       		)
    	)
	)
)

(instance rm110 of Room
	(properties
		picture 011
		style (| dpANIMATION_BLACKOUT dpOPEN_FADEPALETTE)
		horizon 50
		vanishingX 130
		vanishingY 50
		noun N_ROOM
	)
	
	(method (init)
		(AddPolygonsToRoom @P_Default111)
		(super init:)
		(switch gPreviousRoomNumber
			; Add room numbers here to set up the ego when coming from different directions.
			(else 
				(SetUpEgo -1 1)
				(gEgo posn: 150 130)
			)
		)
		;(gEgo init:)
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
			setStep: 5 3
			setCycle: StopWalk -1
			setScript: cedricScript
			init:
		)
		(roll
			setScript: rollScript
			moveSpeed: 20
			cycleSpeed: 20
			init:
		)
		(ghram 
			ignoreHorizon:
			view: 117
			cel: 0
			;setCycle: Forward
			;setMotion: MoveTo 420 160 
			moveSpeed: 20
			cycleSpeed: 20
			;setScale: ScaleTo 100
			init:
			
		)

		(gEgo hide: true)
		(gGame handsOn:)
	)
	
	(method (doit)
        (super doit:)
        (if 
        	(and
        		(<= (guy distanceTo: ghram) 25)
        		(not (Btest F_GuyDead))
			)
            (Die)
        )
        (if (>= (ghram x?) 330)
        	(AddToScore 200)
        	(ghram
        		setMotion: 0
        		x: 10
        		hide:
        		dispose: ;not disposing
        	)
		)
    )
)

(instance cedricScript of Script
    (properties)

    (method (doit)
        (super doit:)
        (if (<= (cedric distanceTo: ghram) 5)
            (Die)
        )
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
				(= seconds (Random 5 10))
			)
			(2
				
				(cedric 
					;view: 112
					ignoreHorizon:
					ignoreControl:
					;setCycle: Forward
					;x: (Random 10 320)
					;y: 15
					setMotion: MoveTo (ghram x?) (- (ghram y?) 15) self
				)	
				(= state 1)
			)
			(66
				(cedric loop: 3 setCycle: EndLoop self)
			)
			(67
				(cedric
					loop: 0
					setCycle: Forward
					x: (Random 10 320)
					y: -15
				)
				(= state 1)
				(= seconds (Random 2 15))
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
					x: (- (ghram x?) 10)
					setCycle: EndLoop self
				)
			)
			
			(2
				(roll
					loop: 1
					;y: (- (ghram y?) 10)
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

