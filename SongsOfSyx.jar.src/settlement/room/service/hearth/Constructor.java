/*     */ package settlement.room.service.hearth;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_HEARTH blue;
/*  30 */   final FurnisherStat services = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */ 
/*     */   
/*     */   static final int codeService = 1;
/*     */   
/*     */   static final int codeFire = 2;
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_HEARTH blue, RoomInitData init) throws IOException {
/*  39 */     super(init, 1, 1, 88, 44);
/*  40 */     this.blue = blue;
/*     */     
/*  42 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  44 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sp, "BENCH_1X1")
/*     */       {
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  50 */           DIR d2 = (DIR)DIR.ORTHO.getC(item.rotation + 1);
/*     */           
/*  52 */           if (d2.x() * d.x() == 0 && d2.y() * d.y() == 0) {
/*  53 */             return false;
/*     */           }
/*  55 */           if (item.get(rx + -d.x() * 4, ry - d.y() * 4) == null)
/*  56 */             return true; 
/*  57 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  62 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "HEARTH_COMBO");
/*     */     
/*  64 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  73 */           super.render(r, s, data, it, degrade, false);
/*  74 */           if (blue.is(it.tile())) {
/*  75 */             HearthInstance ins = (HearthInstance)blue.getter.get(it.tile());
/*     */             
/*  77 */             RESOURCES.WOOD().renderLaying(r, it.x(), it.y(), it.ran(), 5.0D);
/*     */             
/*  79 */             SETT.LIGHTS().hide(it.tx(), it.ty(), (ins.used == 0));
/*     */           } 
/*     */ 
/*     */           
/*  83 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  88 */     FurnisherItemTile ff = (new FurnisherItemTile(
/*  89 */         this, 
/*  90 */         (RoomSprite)roomSpriteCombo2, 
/*  91 */         AVAILABILITY.SOLID, 
/*  92 */         false)).setData(2);
/*  93 */     FurnisherItemTile fe = new FurnisherItemTile(
/*  94 */         this, 
/*  95 */         (RoomSprite)roomSpriteCombo1, 
/*  96 */         AVAILABILITY.SOLID, 
/*  97 */         false);
/*  98 */     FurnisherItemTile bb = (new FurnisherItemTile(
/*  99 */         this, 
/* 100 */         false, 
/* 101 */         (RoomSprite)roomSprite1x1, 
/* 102 */         AVAILABILITY.PENALTY4, 
/* 103 */         false)).setData(1);
/*     */ 
/*     */     
/* 106 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 107 */         this, 
/* 108 */         null, 
/* 109 */         AVAILABILITY.ROOM, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 163 */     return (Room)new HearthInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 168 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hearth\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */