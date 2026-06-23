/*    */ package game.boosting;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.Dic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class All
/*    */ {
/* 14 */   public final BoostableCat WORLD_CIVICS = new BoostableCat("WORLD_", String.valueOf(Dic.¤¤World) + ": " + String.valueOf(Dic.¤¤World), "", 2, (SPRITE)(UI.icons()).s.world);
/* 15 */   public final BoostableCat WORLD_PRODUCTION = new BoostableCat("WORLD_", String.valueOf(Dic.¤¤World) + ": " + String.valueOf(Dic.¤¤World), "", 2, (SPRITE)(UI.icons()).s.world);
/* 16 */   public final BoostableCat WORLD = new BoostableCat("WORLD_", Dic.¤¤World, "", 2, (SPRITE)(UI.icons()).s.world);
/* 17 */   public final BoostableCat RELIGION = new BoostableCat("RELIGION_", BoostableCat.¤¤conversion, "", 6, (SPRITE)(UI.icons()).s.shrine);
/* 18 */   public final BoostableCat WORLD_DUMP = new BoostableCat("WORLD_", String.valueOf(Dic.¤¤World) + ": " + String.valueOf(Dic.¤¤World), "", 1, (SPRITE)(UI.icons()).s.world);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoostableCat$All.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */