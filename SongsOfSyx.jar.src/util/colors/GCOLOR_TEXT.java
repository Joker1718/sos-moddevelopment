/*    */ package util.colors;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.color.ColorShifting;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ public final class GCOLOR_TEXT
/*    */ {
/* 13 */   private Json d = (new Json(PATHS.SPRITE_UI().getLikeHells("Colors.txt"))).json("TEXT");
/*    */   
/* 15 */   public final COLOR IGREAT = (COLOR)new ColorImp(this.d, "IGREAT");
/* 16 */   public final COLOR IGOOD = (COLOR)new ColorImp(this.d, "IGOOD");
/* 17 */   public final COLOR INORMAL = (COLOR)new ColorImp(this.d, "INORMAL");
/* 18 */   public final COLOR IBAD = (COLOR)new ColorImp(this.d, "IBAD");
/* 19 */   public final COLOR IWORST = (COLOR)new ColorImp(this.d, "IWORST");
/*    */   
/* 21 */   public final COLOR HOVERABLE = (COLOR)new ColorImp(this.d, "HOVERABLE");
/* 22 */   public final COLOR H1 = (COLOR)new ColorImp(this.d, "H1");
/* 23 */   public final COLOR H2 = (COLOR)new ColorImp(this.d, "H2");
/* 24 */   public final COLOR ERROR = (COLOR)new ColorImp(this.d, "ERROR");
/* 25 */   public final COLOR WARNING = (COLOR)new ColorImp(this.d, "WARNING");
/*    */   
/* 27 */   public final COLOR CLICKABLE = (COLOR)new ColorImp(this.d, "CLICKABLE");
/* 28 */   public final COLOR HOVERED = (COLOR)new ColorShifting((COLOR)new ColorImp(this.d, "HOVERED"), 
/* 29 */       (COLOR)new ColorImp(this.d, "HOVERED_SELECTED"));
/* 30 */   public final COLOR SELECTED = (COLOR)new ColorImp(this.d, "SELECTED");
/* 31 */   public final COLOR HOVER_SELECTED = (COLOR)new ColorShifting((COLOR)new ColorImp(this.d, "HOVERED"), 
/* 32 */       (COLOR)new ColorImp(this.d, "HOVERED_SELECTED"));
/* 33 */   public final COLOR INACTIVE = (COLOR)new ColorImp(this.d, "INACTIVE");
/* 34 */   public final COLOR NORMAL = (COLOR)new ColorImp(this.d, "NORMAL");
/* 35 */   public final COLOR NORMAL2 = (COLOR)new ColorImp(this.d, "NORMAL2");
/*    */ 
/*    */   
/*    */   public COLOR faction(Faction faction) {
/* 39 */     if (faction == null)
/* 40 */       return COLOR.WHITE65; 
/* 41 */     return (COLOR)ColorImp.TMP.set((COLOR)faction.banner().colorBG()).shadeSelf(1.5D);
/*    */   }
/*    */ 
/*    */   
/* 45 */   private final ColorImp tmp = new ColorImp();
/*    */   
/*    */   public COLOR bronzeGold(double d) {
/* 48 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 49 */     if (d < 0.5D) {
/* 50 */       this.tmp.interpolate(this.INACTIVE, this.H2, d * 2.0D);
/*    */     } else {
/* 52 */       this.tmp.interpolate(this.H2, this.H1, (d - 0.5D) * 2.0D);
/*    */     } 
/* 54 */     return (COLOR)this.tmp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\colors\GCOLOR_TEXT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */