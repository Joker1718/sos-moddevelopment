/*     */ package settlement.room.knowledge.laboratory;
/*     */ 
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
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
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
/*  44 */   public final FurnisherStat knowledge = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  48 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  53 */         return GFORMAT.i(t, (int)(value * Constructor.this.blue.data.knowledgePerStation));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static final int WORK = 1;
/*     */   
/*     */   private final ROOM_LABORATORY blue;
/*     */   final RoomSprite1x1 schair;
/*     */   
/*     */   protected Constructor(final ROOM_LABORATORY blue, RoomInitData init) throws IOException {
/*  64 */     super(init, 1, 2, 88, 44);
/*  65 */     this.blue = blue;
/*     */     
/*  67 */     Json sj = init.data().json("SPRITES");
/*     */     
/*  69 */     this.schair = new RoomSprite1x1(sj, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  73 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry) != this);
/*     */         }
/*     */       };
/*     */     
/*  77 */     final RoomSprite1x1 tablet = new RoomSprite1x1(sj, "TABLE_KNOWLEDGE_ONTOP_1X1");
/*     */     
/*  79 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sj, "TABLE_COMBO", sj)
/*     */       {
/*     */         final RoomSprite1x1 ontop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  91 */           if (blue.job.used(it.tx(), it.ty())) {
/*  92 */             int i = 0;
/*  93 */             for (DIR d : DIR.ORTHO) {
/*  94 */               if ((SETT.ROOMS()).fData.sprite.is(it.tx(), it.ty(), d, Constructor.this.schair)) {
/*  95 */                 tablet.render(r, s, i, it, degrade, false);
/*     */                 break;
/*     */               } 
/*  98 */               i++;
/*     */             } 
/*     */           } 
/*     */           
/* 102 */           this.ontop.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 107 */           return this.ontop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/* 111 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 116 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile()) && blue.is(it.tx(), it.ty())) {
/*     */             
/* 118 */             int f = blue.data.usedD & 0xFF;
/* 119 */             int d = it.ran() & 0x3F;
/*     */             
/* 121 */             int m = 4;
/* 122 */             while (f > d && m-- > 0) {
/* 123 */               tablet.renderRandom(r, s, it, it.ran(), degrade);
/* 124 */               it.ranOffset(1, 0);
/* 125 */               f -= d;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 133 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sj, "SHELF_1X1", sj)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 144 */           if (blue.job.used(it.tx(), it.ty())) {
/* 145 */             this.top.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 152 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 157 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 162 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sj, "WORK_STANDALONE_1X1");
/*     */     
/* 164 */     FurnisherItemTile __ = null;
/* 165 */     FurnisherItemTile sh = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, true);
/* 166 */     FurnisherItemTile st = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, true);
/* 167 */     FurnisherItemTile ch = new FurnisherItemTile(this, true, (RoomSprite)this.schair, AVAILABILITY.AVOID_PASS, true);
/* 168 */     FurnisherItemTile ex = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, true);
/* 169 */     FurnisherItemTile ww = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, false);
/* 170 */     ex.setData(1);
/* 171 */     ww.setData(1);
/* 172 */     sh.setData(1);
/* 173 */     st.setData(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 241 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 246 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 251 */     return (Room)new LaboratoryInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 256 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */   
/*     */   public boolean isHeavy() {
/* 260 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */