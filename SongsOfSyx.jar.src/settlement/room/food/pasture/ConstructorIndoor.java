/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ConstructorIndoor
/*     */   extends Constructor
/*     */ {
/*     */   private ROOM_PASTURE blue;
/*     */   public static final int STORAGE1 = 100;
/*     */   public static final int STORAGE2 = 200;
/*     */   public static final int STORAGE3 = 300;
/*     */   final FurnisherItemTile s1;
/*     */   final FurnisherItemTile s2;
/*     */   final FurnisherItemTile s3;
/*     */   
/*     */   protected ConstructorIndoor(ROOM_PASTURE blue, RoomInitData init) throws IOException {
/*  32 */     super(blue, init);
/*  33 */     this.blue = blue;
/*     */ 
/*     */     
/*  36 */     Json js = init.data().json("SPRITES");
/*     */     
/*  38 */     this.s1 = (new FurnisherItemTile(this, true, (RoomSprite)new SpriteDep(js, blue.s1), AVAILABILITY.ROOM_SOLID, false)).setData(1);
/*  39 */     this.s1.setData(100);
/*  40 */     this.s2 = (new FurnisherItemTile(this, true, (RoomSprite)new SpriteDep(js, blue.s2), AVAILABILITY.ROOM_SOLID, false)).setData(1);
/*  41 */     this.s2.setData(200);
/*  42 */     this.s3 = (new FurnisherItemTile(this, true, (RoomSprite)new SpriteDep(js, blue.s3), AVAILABILITY.ROOM_SOLID, false)).setData(1);
/*  43 */     this.s3.setData(300);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     flush(1, 1, 3);
/*     */     
/*  53 */     makeAux(js);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_PASTURE blue() {
/*  76 */     return this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needsIsolation() {
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/*  90 */     super.putFloor(tx, ty, upgrade, area);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private static class SpriteDep
/*     */     extends RoomSprite1x1 {
/*     */     private final RoomResStorage st;
/*     */     
/*     */     public SpriteDep(Json json, RoomResStorage st) throws IOException {
/* 104 */       super(json, "STORAGE_1X1");
/* 105 */       this.st = st;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 112 */       boolean ret = super.render(r, s, data, it, degrade, isCandle);
/* 113 */       this.st.render(r, s, it.tx(), it.ty(), it.x(), it.y(), it.ran());
/*     */       
/* 115 */       return ret;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fenceJoin(FurnisherItemTile gc) {
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ConstructorIndoor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */