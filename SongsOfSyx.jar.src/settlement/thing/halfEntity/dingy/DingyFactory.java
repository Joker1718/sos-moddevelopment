/*     */ package settlement.thing.halfEntity.dingy;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.fish.ROOM_FISHERY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.thing.halfEntity.Factory;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ public class DingyFactory extends Factory<Dingy> {
/*  26 */   public final Sprite sprite = new Sprite();
/*     */   
/*     */   public DingyFactory(LISTE<Factory<?>> all) throws IOException {
/*  29 */     super(all);
/*     */     
/*  31 */     PlacableSimpleTile placableSimpleTile = new PlacableSimpleTile("Dingy place")
/*     */       {
/*     */         
/*     */         public void place(int tx, int ty)
/*     */         {
/*  36 */           Humanoid h = h();
/*  37 */           if (h != null) {
/*  38 */             DingyFactory.this.make(h, tx, ty, ((IndustryResource)((Industry)((ROOM_FISHERY)(SETT.ROOMS()).FISHERIES.get(0)).industries().get(0)).outs().get(0)).resource, RND.rInt(), (DIR)DIR.ALL.rnd());
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/*  44 */           return ((SETT.TERRAIN()).WATER.DEEP.is(tx, ty) || (SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty)) ? null : E;
/*     */         }
/*     */         
/*     */         private Humanoid h() {
/*  48 */           for (int i = 0; i < (SETT.ENTITIES().getAllEnts()).length; i++) {
/*  49 */             ENTITY e = SETT.ENTITIES().getAllEnts()[i];
/*  50 */             if (e instanceof Humanoid)
/*  51 */               return (Humanoid)e; 
/*     */           } 
/*  53 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  58 */     IDebugPanelSett.add((PLACABLE)placableSimpleTile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Dingy make() {
/*  82 */     return new Dingy();
/*     */   }
/*     */   
/*     */   public boolean make(Humanoid h, int tx, int ty, RESOURCE rCatch, int up, DIR dir) {
/*  86 */     Dingy e = (Dingy)create();
/*  87 */     return e.init(h, tx, ty, rCatch, up, dir);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBoat(Renderer r, ShadowBatch s, int cx, int cy, DIR dir, int ran, int up) {
/*  92 */     int x1 = cx - 64;
/*  93 */     int y1 = cy - 64;
/*     */     
/*  95 */     double sp = 10.0D / (1 + (ran & 0xF));
/*  96 */     ran >>= 4;
/*  97 */     int f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/*  98 */     ran >>= 4;
/*  99 */     int df = MATH.distanceC(8, f, 16);
/* 100 */     x1 += df;
/*     */     
/* 102 */     sp = 10.0D / (1 + (ran & 0xF));
/* 103 */     ran >>= 4;
/* 104 */     f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/* 105 */     ran >>= 4;
/* 106 */     df = MATH.distanceC(8, f, 16);
/* 107 */     y1 += df;
/*     */     
/* 109 */     this.sprite.render((SPRITE_RENDERER)r, s, dir.id(), x1, y1, ran >> 1, up);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\dingy\DingyFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */