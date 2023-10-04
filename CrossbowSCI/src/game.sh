;;; Sierra Script 1.0 - (do not remove this comment)
;
; * SCI Game Header
; *************************************************************************
; * Put all the defines specific to your game in here
(include Verbs.sh)
(include Talkers.sh)

; e.g.
(define MAIN_SCRIPT 0)
(define INGAME_DEBUG_SCRIPT 10)
(define DISPOSECODE_SCRIPT 11)
(define COLORINIT_SCRIPT 12)
(define ABOUT_SCRIPT 13)
(define DEBUGOUT_SCRIPT 14)
(define INVENTORY_SCRIPT 15)
(define DEBUGROOM_SCRIPT 16)
(define DEATH_SCRIPT 20)
(define PRITALKER_SCRIPT 22)
(define GAMECONTROLS_SCRIPT 24)
(define CHOICETALKER_SCRIPT 30)
(define SPEAKWINDOW_SCRIPT 877)
(define INSET_SCRIPT 923)
(define CONVERSATION_SCRIPT 925)
(define FLIPPOLY_SCRIPT 926)
(define PATHAVOIDER_SCRIPT 927)
(define PATHFOLLOW_SRIPT 932)
(define SLIDER_SCRIPT 934)
(define OSCILLATE_SCRIPT 939)
(define MOVECYCLE_SCRIPT 942)
(define POLYGONEDIT_SCRIPT 943)
(define DIALOGEDIT_SCRIPT 947)
(define FEATUREWRITER_SCRIPT 948)
(define MOVEFORWARD_SCRIPT 951)
(define DOOR_SCRIPT 954)
(define FORWARDCOUNT_SCRIPT 956)
(define DISPOSELOAD_SCRIPT 958)
(define DIRECTPATH_SCRIPT 964)
(define REVERSECYCLE_SCRIPT 969)
(define SCALETO_SRIPT 975)
(define CONTROLSBASE_SCRIPT 978)
(define SAVERESTORE_SCRIPT 990)
(define FILE_SCRIPT 993)
(define TITLEROOM_SCRIPT 100)
; Indices for the icons in the icon bar
(define ICONINDEX_WALK 0)
(define ICONINDEX_LOOK 1)
(define ICONINDEX_DO 2)
(define ICONINDEX_TALK 3)
(define ICONINDEX_CUSTOM 4)
(define ICONINDEX_CURITEM 5)
(define ICONINDEX_INVENTORY 6)
(define ICONINDEX_SETTINGS 7)
(define ICONINDEX_HELP 8)

; flags
(enum
    F_GuyDead
    F_CedricDead
    F_HoboDead
    F_rollDead
    F_sonnyDead
    F_sonnyClear
    F_marieDead
    F_marieClear
    ; You can add more here later...
)