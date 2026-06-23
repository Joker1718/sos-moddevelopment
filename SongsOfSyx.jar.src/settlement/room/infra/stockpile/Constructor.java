/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.job.StorageCrate;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Json;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*  31 */   final FurnisherStat storage = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  35 */         return fromItems * (Constructor.this.blue.upgrades().boost(0) - 1.0D);
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  40 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */   
/*     */   private final ROOM_STOCKPILE blue;
/*     */   private final FurnisherItemTile cr;
/*     */   
/*     */   boolean isCrate(int tx, int ty) {
/*  48 */     return (SETT.ROOMS()).fData.tile.is(tx, ty, this.cr);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_STOCKPILE blue, RoomInitData init) throws IOException {
/*  53 */     super(init, 1, 1, 88, 44);
/*  54 */     this.blue = blue;
/*     */     
/*  56 */     Json sp = init.data().json("SPRITES");
/*     */ 
/*     */ 
/*     */     
/*  60 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "CRATE_BOTTOM_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */         
/*     */         final RoomSprite topf;
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  67 */           RoomSprite top = this.top;
/*  68 */           if ((SETT.ROOMS()).STOCKPILE.is(it.tile())) {
/*  69 */             StockpileInstance ins = (StockpileInstance)blue.getter.get(it.tx(), it.ty());
/*  70 */             StorageCrate cr = blue.crate.get(it.tx(), it.ty(), ins, ins.sdata);
/*  71 */             RESOURCE res = cr.resource();
/*  72 */             if (res != null && RESOURCES.EDI().is(res)) {
/*  73 */               top = this.topf;
/*     */             }
/*     */           } 
/*  76 */           top.render(r, s, data, it, degrade, this.rotates);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  81 */           super.render(r, s, data, it, degrade, false);
/*  82 */           if ((SETT.ROOMS()).STOCKPILE.is(it.tile())) {
/*  83 */             StockpileInstance ins = (StockpileInstance)blue.getter.get(it.tx(), it.ty());
/*  84 */             StorageCrate cr = blue.crate.get(it.tx(), it.ty(), ins, ins.sdata);
/*  85 */             RESOURCE res = cr.resource();
/*  86 */             if (res != null) {
/*  87 */               double a = cr.amount();
/*  88 */               res.renderLayingRel(r, it.x(), it.y(), it.ran(), a / blue.upgrades().boost(((StockpileInstance)(SETT.ROOMS()).STOCKPILE.getter.get(it.tx(), it.ty())).upgrade()));
/*     */             } 
/*     */           } 
/*  91 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  95 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "MISC_1X1");
/*     */     
/*  97 */     this.cr = new FurnisherItemTile(
/*  98 */         this, 
/*  99 */         true, 
/* 100 */         (RoomSprite)roomSprite1x11, 
/* 101 */         AVAILABILITY.ROOM_SOLID, 
/* 102 */         false);
/*     */     
/* 104 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 105 */         this, 
/* 106 */         false, 
/* 107 */         (RoomSprite)roomSprite1x12, 
/* 108 */         AVAILABILITY.ROOM_SOLID, 
/* 109 */         true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 186 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 196 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 201 */     return true;
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
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 226 */     return (Room)new StockpileInstance(this.blue, area, init);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */