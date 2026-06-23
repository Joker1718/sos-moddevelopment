/*    */ package init.race;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import init.race.appearence.RExtras;
/*    */ import init.race.appearence.RaceFrameMaker;
/*    */ import init.race.appearence.RaceSheet;
/*    */ import init.sprite.UI.Icon;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.Tuple;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ExpandInit
/*    */ {
/* 17 */   public final KeyMap<Tuple<Icon, Icon>> icons = new KeyMap();
/* 18 */   public final KeyMap<RaceSheet> map = new KeyMap();
/* 19 */   public final KeyMap<RExtras> extras = new KeyMap();
/* 20 */   public final KeyMap<RaceSheet> children = new KeyMap();
/* 21 */   public final KeyMap<String[]> names = new KeyMap();
/* 22 */   public final KeyMap<TILE_SHEET> skelletons = new KeyMap();
/* 23 */   public final KeyMap<TILE_SHEET> portraits = new KeyMap();
/* 24 */   public final KeyMap<TILE_SHEET> sleep = new KeyMap();
/* 25 */   public final KeyMap<TILE_SHEET> infants = new KeyMap();
/* 26 */   public final KeyMap<TILE_SHEET> crowns = new KeyMap();
/* 27 */   public final KeyMap<KingMessages> kmessagess = new KeyMap();
/*    */   
/* 29 */   public final PATH p = PATHS.INIT().getFolder("race");
/* 30 */   public final PATH pt = PATHS.TEXT().getFolder("race");
/* 31 */   public final PATH sg = PATHS.SPRITE().getFolder("race");
/*    */   
/* 33 */   public final RaceFrameMaker fm = new RaceFrameMaker();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\ExpandInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */