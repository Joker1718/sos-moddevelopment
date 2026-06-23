/*    */ package util.colors;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.color.ColorShifting;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ public final class COLOR_MAP
/*    */ {
/* 15 */   private Json d = (new Json(PATHS.SPRITE_UI().getLikeHells("Colors.txt"))).json("MAP");
/*    */   
/* 17 */   public final COLOR DORMANT = (COLOR)new ColorImp(this.d, "DORMANT");
/* 18 */   public final COLOR BAD = (COLOR)new ColorImp(this.d, "BAD");
/* 19 */   public final COLOR SOSO = (COLOR)new ColorImp(this.d, "SOSO");
/* 20 */   public final COLOR OK = (COLOR)new ColorImp(this.d, "OK");
/* 21 */   public final COLOR BETTER = (COLOR)new ColorImp(this.d, "BETTER");
/*    */   
/* 23 */   public final COLOR OK_2_BETTER = (COLOR)new ColorShifting(this.OK, this.BETTER);
/*    */   
/* 25 */   public final COLOR BEST = (COLOR)new ColorImp(this.d, "BEST");
/* 26 */   public final COLOR BEST_DARK = (COLOR)this.BEST.shade(0.75D);
/*    */   
/* 28 */   public final COLOR JOB_DORMANT = this.DORMANT;
/* 29 */   public final COLOR JOB_ACTIVE = this.OK;
/* 30 */   public final COLOR JOB_RESERVED = this.BETTER;
/* 31 */   public final COLOR JOB_BLOCKED = (COLOR)this.JOB_ACTIVE.shade(0.75D);
/*    */   
/* 33 */   public final COLOR BATTLE_DORMANT = this.DORMANT;
/* 34 */   public final COLOR BATTLE_OK = this.OK;
/*    */   
/* 36 */   public final COLOR OVERLAY_GOOD = (COLOR)new ColorImp(this.d, "OVERLAY_GOOD");
/* 37 */   public final COLOR OVERLAY_BAD = (COLOR)new ColorImp(this.d, "OVERLAY_BAD");
/*    */   
/* 39 */   public final COLOR F_PLAYER = (COLOR)new ColorImp(this.d, "F_PLAYER");
/* 40 */   public final COLOR F_ALLY = (COLOR)new ColorImp(this.d, "F_ALLY");
/* 41 */   public final COLOR F_NEAUTRAL = (COLOR)new ColorImp(this.d, "F_NEAUTRAL");
/* 42 */   public final COLOR F_ENEMY = (COLOR)new ColorImp(this.d, "F_ENEMY");
/* 43 */   public final COLOR F_REBEL = (COLOR)new ColorImp(this.d, "F_REBEL");
/*    */   
/*    */   public COLOR get(Faction f) {
/* 46 */     if (f == null)
/* 47 */       return this.F_REBEL; 
/* 48 */     if (f == FACTIONS.player())
/* 49 */       return this.F_PLAYER; 
/* 50 */     if ((DIP.get((FactionNPC)f)).ally)
/* 51 */       return this.F_ALLY; 
/* 52 */     if (!DIP.WAR().is((Faction)FACTIONS.player(), f)) {
/* 53 */       return this.F_NEAUTRAL;
/*    */     }
/* 55 */     return this.F_ENEMY;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\colors\COLOR_MAP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */