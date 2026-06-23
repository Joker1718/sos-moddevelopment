/*     */ package settlement.room.infra.admin;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherItemTools;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher {
/*  34 */   public final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this);
/*  35 */   public final FurnisherStat stations = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  39 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  44 */         return GFORMAT.i(t, (int)(value * Constructor.this.blue.data.knowledgePerStation));
/*     */       }
/*     */     };
/*  47 */   public final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*     */   
/*     */   private final ROOM_ADMIN blue;
/*     */   
/*     */   final FurnisherItemTile ww;
/*     */   static final int ICHAIR = 3;
/*     */   
/*     */   protected Constructor(final ROOM_ADMIN blue, RoomInitData init) throws IOException {
/*  55 */     super(init, 3, 3, 88, 44);
/*  56 */     this.blue = blue;
/*     */     
/*  58 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  60 */     final RoomSprite1x1 sMisc = new RoomSprite1x1(sp, "MISC_1X1");
/*     */     
/*  62 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  66 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/*  68 */           sMisc.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  73 */           return sMisc.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*  76 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1, sp)
/*     */       {
/*     */         final RoomSprite1x1 idle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  88 */           data = getData2(it);
/*  89 */           Room ro = (SETT.ROOMS()).map.get(it.tile());
/*  90 */           if (ro instanceof AdminInstance && !(SETT.ROOMS()).fData.candle.is(it.tile())) {
/*  91 */             long ran = GUTIL.ran2().get(it.tx(), it.ty()) << 32L | GUTIL.ran2().get(it.tx() + 1, it.ty());
/*  92 */             int am = blue.data.usedD >> 4 & 0xF;
/*  93 */             am -= it.ran() & 0x3;
/*  94 */             DIR d = this.idle.rot(getData2(it));
/*  95 */             for (int i = 0; i < am; i++) {
/*  96 */               int dd = (int)((ran & 0x7L) * 7L);
/*  97 */               DIR dd2 = d.next(2);
/*  98 */               int d2 = (int)(ran >> 3L & 0x1L);
/*  99 */               d2 *= 4;
/* 100 */               ran >>= 4L;
/*     */               
/* 102 */               it.setOff(-d.x() * dd + dd2.x() * d2, -d.y() * dd + dd2.y() * d2);
/* 103 */               this.idle.render(r, s, data, it, degrade, false);
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 112 */           return this.idle.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/* 115 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 119 */           Room ro = (SETT.ROOMS()).map.get(it.tile());
/* 120 */           if (ro instanceof AdminInstance && !(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 121 */             AdminInstance ins = (AdminInstance)ro;
/* 122 */             int am = (int)(16.0D * blue.consumption().stored((IndustryResource)blue.consumption().ins().get(0)).get(ins) / ins.jobs.size());
/*     */ 
/*     */             
/* 125 */             if (am > 0) {
/* 126 */               ((IndustryResource)blue.consumption().ins().get(0)).resource.renderLaying(r, it.x(), it.y(), GUTIL.ran2().get(it.tile()), am);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 132 */     RoomSpriteCombo roomSpriteCombo4 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1, sp)
/*     */       {
/*     */         final RoomSprite idle;
/*     */ 
/*     */ 
/*     */         
/*     */         final RoomSprite active;
/*     */ 
/*     */         
/*     */         final RoomSpriteImp ontop;
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 146 */           if (!blue.is(it.tile()))
/*     */             return; 
/* 148 */           SETT_JOB j = blue.job.get(it.tx(), it.ty());
/*     */           
/* 150 */           if (j.jobReservedIs(null)) {
/*     */ 
/*     */             
/* 153 */             this.ontop.animate((blue.job.used(it.tx(), it.ty()) ? true : false));
/* 154 */             this.active.render(r, s, getData2(it), it, degrade, false);
/* 155 */             this.ontop.render(r, s, getData2(it), it, degrade, false);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 161 */           return this.idle.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/* 165 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "SHELF_1X1", sp)
/*     */       {
/*     */         final RoomSpriteImp ontop;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER re, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 171 */           Room r = (SETT.ROOMS()).map.get(it.tile());
/* 172 */           if (r instanceof AdminInstance) {
/* 173 */             int f = blue.data.usedD & 0xFF;
/* 174 */             if (f >= (it.ran() & 0xFF)) {
/* 175 */               this.ontop.render(re, s, data, it, degrade, false);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 183 */           if (item.width() == 1 || item.height() == 1)
/* 184 */             return (d.orthoID() == item.rotation); 
/* 185 */           if (d.orthoID() == item.rotation || d.perpendicular().orthoID() == item.rotation)
/* 186 */             return (item.sprite(rx, ry) == this); 
/* 187 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 193 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "STOOL_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 196 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */       };
/*     */     
/* 200 */     FurnisherItemTile ss = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false);
/* 201 */     FurnisherItemTile mm = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, false);
/* 202 */     this.ww = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo4, AVAILABILITY.ROOM_SOLID, false);
/* 203 */     FurnisherItemTile tt = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo3, AVAILABILITY.ROOM_SOLID, true);
/* 204 */     FurnisherItemTile in = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x13, AVAILABILITY.AVOID_PASS, true);
/* 205 */     in.setData(3);
/* 206 */     FurnisherItemTile __ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 354 */     flush(3);
/*     */     
/* 356 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 362 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 367 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 372 */     return (Room)new AdminInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 377 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 382 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */