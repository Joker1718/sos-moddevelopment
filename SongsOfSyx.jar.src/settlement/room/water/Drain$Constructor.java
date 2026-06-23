/*     */ package settlement.room.water;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   protected Constructor(RoomInitData init) throws IOException {
/*  89 */     super(init, 1, 0);
/*     */ 
/*     */     
/*  92 */     Json jj = init.data().json("SPRITES");
/*  93 */     final RoomSprite1x1 dd = new RoomSprite1x1(jj, "DRAIN_1X1");
/*     */     
/*  95 */     RoomSprite sp = new WSprite.RSprite(paramDrain, paramDrain.instance.pump, false)
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  99 */           dd.render(r, s, data, it, degrade, false);
/* 100 */           super.renderBelow(r, s, data, it, degrade);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     flush(1, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 118 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 128 */     int tx = area.mX();
/* 129 */     int ty = area.my();
/* 130 */     Drain.this.instance.place(area);
/* 131 */     (SETT.ROOMS()).fData.spriteData2.set(tx, ty, 1);
/* 132 */     for (DIR d : DIR.ORTHO) {
/* 133 */       if (Drain.this.is(tx, ty, d)) {
/* 134 */         (SETT.ROOMS()).fData.spriteData2.set(tx, ty, d, 1);
/*     */       }
/*     */     } 
/*     */     
/* 138 */     return (SETT.ROOMS()).map.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 143 */     int i = 0;
/* 144 */     while (GUTIL.circle().radius(i) < Drain.DrainInstance.radius - 2) {
/* 145 */       int dx = GUTIL.circle().get(i).x() + tx;
/* 146 */       int dy = GUTIL.circle().get(i).y() + ty;
/* 147 */       int rrx = x + GUTIL.circle().get(i).x() * 64;
/* 148 */       int rry = y + GUTIL.circle().get(i).y() * 64;
/* 149 */       if ((SETT.ROOMS()).WATER.pumpable.get(dx, dy) == Drain.this.instance.pump) {
/*     */         
/* 151 */         (SPRITES.cons()).BIG.dashed.render(r, 0, rrx, rry);
/* 152 */       } else if (GUTIL.circle().radius(i) == Drain.DrainInstance.radius - 3) {
/* 153 */         (SPRITES.cons()).BIG.outline.render(r, 0, rrx, rry);
/*     */       } 
/*     */       
/* 156 */       i++;
/*     */     } 
/* 158 */     super.renderExtra(r, x, y, tx, ty, rx, ry, item);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e) {
/* 164 */     return (e == (SETT.ENV()).map.WATER_SWEET);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 171 */     if (blue().is(tx, ty) && (SETT.ROOMS()).data.get(tx, ty) != 0 && e == (SETT.ENV()).map.WATER_SWEET) {
/* 172 */       v.value = 1.0D;
/* 173 */       v.radius = 1.0D;
/* 174 */       return true;
/*     */     } 
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 181 */     return Drain.this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Drain$Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */