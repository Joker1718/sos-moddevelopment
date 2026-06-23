/*    */ package settlement.tilemap.ground;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.info.INFO;
/*    */ 
/*    */ 
/*    */ public class GroundType
/*    */   extends INFO
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public final int index;
/*    */   public final TILE_SHEET sheet;
/* 21 */   public final ColorImp miniC = new ColorImp();
/*    */   boolean special;
/* 23 */   final ColorImp[] tmps = new ColorImp[16];
/*    */   
/*    */   public final SPRITE icon;
/*    */   public final double vegitation;
/*    */   public final double farm;
/*    */   
/*    */   protected GroundType(int index, final TILE_SHEET sheet, CharSequence name, CharSequence desc, double vegitation, double farm) {
/* 30 */     super(name, desc);
/* 31 */     this.index = index;
/* 32 */     this.sheet = sheet;
/* 33 */     for (int i = 0; i < this.tmps.length; i++) {
/* 34 */       this.tmps[i] = new ColorImp();
/*    */     }
/* 36 */     this.icon = (SPRITE)new SPRITE.Imp(32)
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 40 */           GroundType.this.tmps[8].bind();
/* 41 */           sheet.render(r, 0, X1, X1 + 16, Y1, Y1 + 16);
/* 42 */           sheet.render(r, 1, X1 + 16, X2, Y1, Y1 + 16);
/* 43 */           sheet.render(r, 2, X1, X1 + 16, Y1 + 16, Y2);
/* 44 */           sheet.render(r, 3, X1 + 16, X2, Y1 + 16, Y2);
/* 45 */           COLOR.unbind();
/*    */         }
/*    */       };
/* 48 */     this.vegitation = vegitation;
/* 49 */     this.farm = farm;
/*    */   }
/*    */   
/*    */   public void setColors(COLOR dry, COLOR wet, double add) {
/* 53 */     if (this.special)
/*    */       return; 
/* 55 */     for (int i = 0; i < this.tmps.length; i++) {
/*    */       
/* 57 */       double d = i * 0.06666666666666667D;
/*    */       
/* 59 */       this.tmps[i].interpolate(dry, wet, CLAMP.d(d + add, 0.0D, 1.0D));
/*    */     } 
/* 61 */     this.miniC.interpolate(dry, wet, 0.5D - this.index / 8.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   GroundType setColors(Json json) {
/* 66 */     ColorImp colorImp1 = new ColorImp(json, "DRY");
/* 67 */     ColorImp colorImp2 = new ColorImp(json, "WET");
/* 68 */     setColors((COLOR)colorImp1, (COLOR)colorImp2, 0.0D);
/* 69 */     this.special = true;
/* 70 */     return this;
/*    */   }
/*    */   
/*    */   public void placeFixed(int x, int y) {
/* 74 */     (SETT.GROUND()).MAP.set(x, y, this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 80 */     return ((SETT.GROUND()).MAP.get(tile) == this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 85 */     return ((SETT.GROUND()).MAP.get(tx, ty) == this);
/*    */   }
/*    */   
/*    */   public COLOR col(int tile) {
/* 89 */     return (COLOR)this.tmps[(SETT.GROUND()).mapMoistureCurrent.get(tile)];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\GroundType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */