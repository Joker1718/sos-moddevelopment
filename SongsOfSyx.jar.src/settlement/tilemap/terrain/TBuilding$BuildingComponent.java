/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public abstract class BuildingComponent
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final RESOURCE needed;
/*     */   TerrainClearing clearing;
/*     */   
/*     */   protected BuildingComponent(String key, Terrain t, CharSequence name, SPRITE icon, COLOR c, RESOURCE needed) {
/* 290 */     super(key, t, name, icon, c);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     this.clearing = new TerrainClearing()
/*     */       {
/*     */         public RESOURCE clear1(int tx, int ty)
/*     */         {
/* 299 */           TBuilding.BuildingComponent.this.shared.NADA.placeFixed(tx, ty);
/* 300 */           return TBuilding.BuildingComponent.this.needed;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 305 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public int clearAll(int tx, int ty) {
/* 310 */           TBuilding.BuildingComponent.this.shared.NADA.placeFixed(tx, ty);
/* 311 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace sound(int tx, int ty) {
/* 316 */           return (TBuilding.BuildingComponent.access$0(TBuilding.BuildingComponent.this)).sound;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isStructure() {
/* 321 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean canDestroy(int tx, int ty) {
/* 326 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void destroy(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean isEasilyCleared() {
/* 336 */           return false;
/*     */         }
/*     */       };
/*     */     this.needed = needed;
/*     */   }
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
/*     */   public TerrainClearing clearing() {
/* 372 */     return this.clearing;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final TBuilding building() {
/* 378 */     return TBuilding.this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding$BuildingComponent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */