/*     */ package settlement.room.water;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class CanalConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final Canal.Overlay overlay;
/*     */   private final RoomSprite sp;
/*     */   
/*     */   protected CanalConstructor(RoomInitData init) throws IOException {
/* 129 */     super(init, 1, 0);
/*     */     this.overlay = new Canal.Overlay(paramCanal);
/* 131 */     this.sp = new WSprite.RSprite(paramCanal, paramCanal.instance.pump, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     flush(1, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean joinsWithFloor() {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 158 */     int tx = area.mX();
/* 159 */     int ty = area.my();
/* 160 */     Canal.this.instance.place(area);
/* 161 */     (SETT.ROOMS()).fData.spriteData2.set(tx, ty, 1);
/* 162 */     for (DIR d : DIR.ORTHO) {
/* 163 */       if (Canal.this.is(tx, ty, d)) {
/* 164 */         (SETT.ROOMS()).fData.spriteData2.set(tx, ty, d, 1);
/*     */       }
/*     */     } 
/*     */     
/* 168 */     return (SETT.ROOMS()).map.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 173 */     return Canal.this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 181 */     if (blue().is(tx, ty) && (SETT.ROOMS()).data.get(tx, ty) != 0 && e == (SETT.ENV()).map.WATER_SWEET) {
/* 182 */       v.value = 1.0D;
/* 183 */       v.radius = 1.0D;
/* 184 */       return true;
/*     */     } 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e) {
/* 194 */     return (e == (SETT.ENV()).map.WATER_SWEET);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 199 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSpecialAreaPlacable() {
/* 204 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 209 */     super.renderExtra(r, x, y, tx, ty, rx, ry, item);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Addable overlay() {
/* 215 */     return this.overlay;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Canal$CanalConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */