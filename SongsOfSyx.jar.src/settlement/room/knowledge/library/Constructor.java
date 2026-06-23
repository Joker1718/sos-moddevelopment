/*     */ package settlement.room.knowledge.library;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher {
/*  31 */   public final FurnisherStat workers = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  35 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  40 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  45 */   public final FurnisherStat knowledge = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  49 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  54 */         return GFORMAT.f0(t, value * Constructor.this.blue.data.knowledgePerStation);
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(AREA area, double[] fromItems) {
/*  59 */         return super.get(area, fromItems) * Constructor.this.efficiency.get(area, fromItems);
/*     */       }
/*     */     };
/*     */   
/*  63 */   public final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*     */   
/*     */   private final ROOM_LIBRARY blue;
/*     */   
/*     */   final FurnisherItemTile ww;
/*     */   final RoomSprite sStool;
/*     */   
/*     */   protected Constructor(final ROOM_LIBRARY blue, RoomInitData init) throws IOException {
/*  71 */     super(init, 2, 3, 88, 44);
/*  72 */     this.blue = blue;
/*     */     
/*  74 */     Json sj = init.data().json("SPRITES");
/*     */ 
/*     */     
/*  77 */     final RoomSprite1x1 sUsed = new RoomSprite1x1(sj, "WORK_USED_1x1");
/*     */     
/*  79 */     final RoomSpriteCombo sWork = new RoomSpriteCombo(sj, "TABLE_COMBO", sj)
/*     */       {
/*     */         private final RoomSprite1x1 available;
/*     */         
/*     */         private final RoomSprite1x1 dec;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  87 */           if (blue.is(it.tile())) {
/*  88 */             it.ranOffset(1, 0);
/*  89 */             RoomSprite1x1 sp = null;
/*  90 */             if (blue.job.used(it.tx(), it.ty())) {
/*  91 */               sp = sUsed;
/*  92 */             } else if (blue.consumption().ins().size() > 0 && blue.consumption().stored((IndustryResource)blue.consumption().ins().get(0)).get(blue.get(it.tx(), it.ty())) > 0) {
/*  93 */               sp = this.available;
/*     */             } 
/*     */             
/*  96 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  97 */               if ((SETT.ROOMS()).fData.sprite.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(i), Constructor.this.sStool)) {
/*  98 */                 if (sp != null)
/*  99 */                   sp.render(r, s, i, it, degrade, false); 
/* 100 */                 if ((it.ran() & 0x3) == 1) {
/* 101 */                   it.ranOffset(1, 0);
/* 102 */                   this.dec.render(r, s, (i + 2) % 4, it, degrade, false);
/*     */                 } 
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 112 */     this.sStool = (RoomSprite)new RoomSprite1x1(sj, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 116 */           return (item.sprite(rx, ry) == sWork);
/*     */         }
/*     */       };
/*     */     
/* 120 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sj, "SHELF_1X1", sj)
/*     */       {
/*     */         private final RoomSprite1x1 ontop;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 126 */           if (blue.is(it.tile())) {
/* 127 */             int f = blue.data.usedD & 0xFF;
/* 128 */             if (f > (it.ran() & 0xFF)) {
/* 129 */               it.ranOffset(1, 0);
/* 130 */               this.ontop.render(r, s, data, it, degrade, false);
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 137 */           if (item.width() > 2 && item.height() > 2) {
/* 138 */             if ((((DIR)DIR.ORTHO.get(item.rotation)).x() * d.x() != 0 || ((DIR)DIR.ORTHO.get(item.rotation)).y() * d.y() != 0) && item.sprite(rx, ry) == this)
/* 139 */               return true; 
/* 140 */             return false;
/*     */           } 
/* 142 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */       };
/*     */     
/* 146 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sj, "TORCH_1x1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 149 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile()))
/* 150 */             sUsed.renderRandom(r, s, it, it.ran(), degrade); 
/*     */         }
/*     */       };
/* 153 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sj, "DECOR_1x1");
/*     */     
/* 155 */     FurnisherItemTile ss = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false);
/* 156 */     this.ww = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo, AVAILABILITY.ROOM_SOLID, false);
/* 157 */     FurnisherItemTile st = new FurnisherItemTile(this, true, this.sStool, AVAILABILITY.AVOID_PASS, false);
/* 158 */     FurnisherItemTile ca = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, true);
/* 159 */     FurnisherItemTile ni = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, false);
/*     */     
/* 161 */     FurnisherItemTile __ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     flush(1, 3);
/*     */     
/* 226 */     FurnisherItemTools.makeUnder(this, sj, "CARPET_COMBO");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 231 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 236 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 241 */     return (Room)new LibraryInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 246 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 251 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\library\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */