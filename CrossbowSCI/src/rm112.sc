;;; Sierra Script 1.0 - (do not remove this comment)
(script# 112)
(include sci.sh)
(include Verbs.sh)
(include game.sh)
(include 112.shm)
(include 112.shp)
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
	rm112 0
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

(instance zwooshSound of Sound
	(properties
		number 862
		priority 9
	)
)

(instance wolfSound of Sound
	(properties
		number 861
		priority 10
	)
)

(instance splatter of Prop
	(properties
		x -100
		y -100
		view 122
		loop 9
		priority 15
	)
)

(instance heads1 of Prop
	(properties
		x 116
		y 129
		view 121
		loop 1
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads2 of Prop
	(properties
		x 130
		y 23
		view 121
		loop 2
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads3 of Prop
	(properties
		x 178
		y 45
		view 121
		loop 3
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads4 of Prop
	(properties
		x 188
		y 129
		view 121
		loop 4
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads5 of Prop
	(properties
		x 285
		y 53
		view 121
		loop 5
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 300)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads6 of Prop
	(properties
		x 42
		y 96
		view 121
		loop 6
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads7 of Prop
	(properties
		x 12
		y 53
		view 121
		loop 7
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads8 of Prop
	(properties
		x 220
		y 98
		view 121
		loop 8
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads9 of Prop
	(properties
		x 118
		y 70
		view 121
		loop 1
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance heads10 of Prop
	(properties
		x 83
		y 100
		view 121
		loop 1
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(self view: 122 cel: -1 setCycle: BegLoop)
	        	(splatter posn: (self x?) (self y?) setCel: 0 setCycle: EndLoop)
	        	(AddToScore 100)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)


(instance elevator of Actor
	(properties
        view 121
        x 153
        y -10
        signal ignAct
        noun N_GHRAM
    )
    
;;;    (method (doVerb theVerb)
;;;    	(switch theVerb
;;;        	(V_LOOK
;;;        		(Prints {Don't shoot Patti, Please.})
;;;       		)
;;;        	(else
;;;            	(super doVerb: theVerb &rest)
;;;       		)
;;;    	)
;;;	)
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
				(if (== (elevator view?) 121)
					(elevator view: 122)
				 	;(Prints {Don't shoot Patti!})
					(AddToScore -1000)
					(screamSound play:)
				)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance rm112 of Room
	(properties
		picture 013
		style (| dpANIMATION_BLACKOUT dpOPEN_FADEPALETTE)
		horizon 50
		vanishingX 130
		vanishingY 50
		noun N_ROOM
	)
	
	(method (init)
		(AddPolygonsToRoom @P_Default112)
		(super init:)
		(gunSound init:)
;;;		(switch gPreviousRoomNumber
;;;			; Add room numbers here to set up the ego when coming from different directions.
;;;			(else 
;;;				(SetUpEgo -1 1)
;;;				(gEgo posn: 150 130)
;;;			)
;;;		)
		;(gEgo init:)
		;(guy init:)
		(elevator 
			ignoreHorizon:
			view: 121
			cel: 0
			;setCycle: Forward
			;setMotion: MoveTo 420 160 
			moveSpeed: 8 ;20
			;cycleSpeed: 20
			;setScale: ScaleTo 100
			init:
		)
		(splatter init:)
		;(elevator setScript: elevatorScript)
		(gGame setScript: sCartoon)

		;(gEgo hide: true)
		(gGame handsOn:)
	)
	
;;;	(method (doit)
;;;        (super doit:)
;;;;;;        (if 
;;;;;;        	(and
;;;;;;        		(<= (guy distanceTo: elevator) 25)
;;;;;;        		(not (Btest F_GuyDead))
;;;;;;			)
;;;;;;            (Die)
;;;;;;        )
;;;        (if (>= (elevator x?) 330)
;;;        	(AddToScore 200)
;;;        	(elevator
;;;        		setMotion: 0
;;;        		x: 10
;;;        		;hide:
;;;        		dispose: ;not disposing
;;;        	)
;;;		)
;;;    )
	(method (doit)
		(switch (elevator y?)
			(32
				;(proc0_14 860 0 67 -1 15 70 280)
				(zwooshSound play:)
				(heads2 init: setScript: sPeeping)
			)
			(76
				(zwooshSound play:)
				(heads3 init: setScript: sPeeping)
			)
			(94
				(zwooshSound play:)
				(heads5 init: setScript: sPeeping)
				(heads7 init: setScript: sPeeping)
				(heads9 init: setScript: sPeeping)
			)
			(120
				(zwooshSound play:)
				(heads8 init: setScript: sPeeping)
				(heads10 init: setScript: sPeeping)
			)
			(138
				(zwooshSound play:)
				(heads4 init: setScript: sPeeping)
			)
			(148
				(zwooshSound play:)
				(heads1 init: setScript: sPeeping)
				(heads6 init: setScript: sPeeping)
			)
			;(178 (proc0_14 860 1))
		)
	)
	
	(method (doVerb theVerb)
	    (switch theVerb
	        (V_LOOK
	        	(gunSound play:)
	        	(AddToScore -10)
	        )
	        (else
	            (super doVerb: theVerb &rest)
	        )
	    )
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(DrawPic 12 100 0)
				(elevator
					setCycle: 0
					setLoop: 0
					setPri: 1
					setMotion: MoveTo 153 242 self
				)
			)
			(2
				(gRoom newRoom: 111)
				(self dispose:)
			)
		)
	)
)

(instance sPeeping of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (client setCycle: EndLoop self))
			(1
				(wolfSound play:)
				;(client stopUpd:)
				;(self dispose:)
			)
		)
	)
)
