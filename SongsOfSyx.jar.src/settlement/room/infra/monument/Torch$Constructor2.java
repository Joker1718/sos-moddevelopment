/*     */ package settlement.room.infra.monument;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Constructor2
/*     */   extends MConstructor
/*     */ {
/*     */   public final RoomSprite small;
/*     */   public final RoomSprite medium;
/*     */   final FurnisherItemTile ss;
/*     */   final FurnisherItemTile sm;
/*     */   
/*     */   protected Constructor2(RoomInitData init) throws IOException {
/*  51 */     super(paramTorch, init);
/*  52 */     Json js = init.data().json("SPRITES");
/*     */     
/*  54 */     this.small = (RoomSprite)new RoomSprite1x1(js, "SMALL_1X1")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  58 */           super.render(r, s, data, it, degrade, isCandle);
/*  59 */           int am = (int)((1.0D - (SETT.ROOMS()).map.get(it.tx(), it.ty()).getDegrade(it.tx(), it.ty())) * 4.0D);
/*  60 */           RESOURCES.WOOD().renderLaying(r, it.x(), it.y(), it.ran(), am);
/*  61 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  65 */     this.medium = (RoomSprite)new RoomSpriteCombo(js, "COMBO")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  70 */           super.render(r, s, data, it, degrade, isCandle);
/*  71 */           if ((data & DIR.N.mask()) != 0 && (data & DIR.W.mask()) != 0) {
/*  72 */             int am = (int)((1.0D - (SETT.ROOMS()).map.get(it.tx(), it.ty()).getDegrade(it.tx(), it.ty())) * 8.0D);
/*  73 */             RESOURCES.WOOD().renderLaying(r, it.x() - 32, it.y() - 32, it.ran(), am);
/*     */           } 
/*  75 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  80 */     this.ss = new FurnisherItemTile(
/*  81 */         this, 
/*  82 */         this.small, 
/*  83 */         AVAILABILITY.SOLID, 
/*  84 */         false);
/*     */     
/*  86 */     this.sm = new FurnisherItemTile(
/*  87 */         this, 
/*  88 */         this.medium, 
/*  89 */         AVAILABILITY.SOLID, 
/*  90 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     flush(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 108 */     if (area.body().width() == 2) {
/* 109 */       SETT.LIGHTS().torchBig(area.body().x1(), area.body().y1(), 32);
/*     */     } else {
/* 111 */       SETT.LIGHTS().torch(area.body().x1(), area.body().y1(), 0);
/*     */     } 
/* 113 */     return super.create(area, init);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\Torch$Constructor2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */