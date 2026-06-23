/*     */ package settlement.room.health.hospital;
/*     */ 
/*     */ import init.sprite.game.SheetType;
/*     */ import init.sprite.game.Sheets;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
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
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_HOSPITAL blue;
/*     */   static final int CODE_S = 1;
/*  34 */   final FurnisherStat patients = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  35 */   final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this);
/*     */   
/*     */   protected Constructor(final ROOM_HOSPITAL blue, RoomInitData init) throws IOException {
/*  38 */     super(init, 1, 2, 88, 44);
/*  39 */     this.blue = blue;
/*     */     
/*  41 */     Json js = init.data().json("SPRITES");
/*     */     
/*  43 */     RoomSprite1x1 sGrime = new RoomSprite1x1(js, "BED_1X1_GRIME");
/*     */     
/*  45 */     SBedSprite sBedSprite1 = new SBedSprite(sGrime, js, "BED_TOP_1X1", false);
/*     */     
/*  47 */     SBedSprite sBedSprite2 = new SBedSprite(this, sGrime, js, "BED_BOTTOM_1X1", true)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  50 */           if (Bed.res2(it.tx(), it.ty())) {
/*  51 */             ((IndustryResource)((Industry)blue.indus.get(0)).ins().get(1)).resource.renderLaying(r, it.x(), it.y(), it.ran(), 1.0D);
/*     */           }
/*     */         }
/*     */       };
/*  55 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(js, "TABLE_COMBO", js)
/*     */       {
/*     */         private final RoomSprite top;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  61 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/*  62 */             this.top.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, false);
/*     */           }
/*     */         }
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  67 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  72 */     FurnisherItemTile bb = new FurnisherItemTile(this, false, (RoomSprite)sBedSprite1, AVAILABILITY.NOT_ACCESSIBLE, false);
/*  73 */     FurnisherItemTile ss = new FurnisherItemTile(this, true, (RoomSprite)sBedSprite2, AVAILABILITY.NOT_ACCESSIBLE, false);
/*  74 */     ss.setData(1);
/*     */     
/*  76 */     FurnisherItemTile tt = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo, AVAILABILITY.ROOM_SOLID, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 163 */     return (Room)new HospitalInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 168 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class SBedSprite
/*     */     extends RoomSprite1xN
/*     */   {
/*     */     private Sheets made;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private RoomSprite1x1 grime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SBedSprite(RoomSprite1x1 grime, Json json, String key, boolean master) throws IOException {
/* 194 */       super(json, key, master);
/* 195 */       this.made = new Sheets((SheetType)SheetType.s1x1, json.json(key + "_UNMADE"));
/* 196 */       this.grime = grime;
/*     */     }
/*     */ 
/*     */     
/*     */     public Sheets sheet(RenderData.RenderIterator it) {
/* 201 */       int data = (SETT.ROOMS()).fData.spriteData.get(it.tile());
/* 202 */       int x = it.tx() + offX(data);
/* 203 */       int y = it.ty() + offY(data);
/*     */       
/* 205 */       if (Bed.res1(x, y)) {
/* 206 */         return super.sheet(it);
/*     */       }
/* 208 */       return this.made;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 214 */       boolean ret = super.render(r, s, data, it, degrade, isCandle);
/* 215 */       int x = it.tx() + offX(data);
/* 216 */       int y = it.ty() + offY(data);
/* 217 */       if (!Bed.made(x, y)) {
/* 218 */         this.grime.renderRandom(r, s, it, it.ran(), 0.0D);
/*     */       }
/* 220 */       return ret;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */