/*     */ package world.entity.caravan;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.WEntityConstructor;
/*     */ import world.map.pathing.WPath;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ public final class Shipment
/*     */   extends WEntity
/*     */ {
/*     */   public static final int MAX_DISTANCE = 550;
/*  33 */   private static double speed = 6.4D;
/*     */   
/*  35 */   private final WPath path = new P();
/*     */   private short destReg;
/*     */   private short destFaction;
/*  38 */   private final int[] payload = Alloc.ii(TR.ALL().size());
/*     */   
/*     */   private byte type;
/*  41 */   private byte size = -1;
/*     */   
/*     */   Shipment() {
/*  44 */     super(64, 64);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  49 */     file.s(this.destReg);
/*  50 */     file.s(this.destFaction);
/*  51 */     file.b(this.type);
/*  52 */     TR.MAP().saver().save(this.payload, file);
/*  53 */     this.path.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WEntity load(FileGetter file) throws IOException {
/*  58 */     this.destReg = file.s();
/*  59 */     this.destFaction = file.s();
/*  60 */     this.type = file.b();
/*  61 */     TR.MAP().loader().load(this.payload, file, 0);
/*  62 */     this.path.load(file);
/*  63 */     this.size = -1;
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderAboveTerrain(Renderer r, ShadowBatch s, float ds, int x, int y) {
/*     */     int i;
/*  71 */     if (WORLD.FOW().is(ctx(), cty())) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  76 */     if ((WORLD.WATER()).isBig.is(body().cX() >> 6, body().cY() >> 6)) {
/*  77 */       i = 24;
/*     */     } else {
/*  79 */       i = GAME.intervals().get05() % 3;
/*  80 */       i *= 8;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  85 */     if (this.size == -1) {
/*  86 */       int size = 0; byte b; int j, arrayOfInt[];
/*  87 */       for (j = (arrayOfInt = this.payload).length, b = 0; b < j; ) { int py = arrayOfInt[b];
/*  88 */         size += py; b++; }
/*  89 */        size /= 256;
/*  90 */       this.size = (byte)CLAMP.i(size, 0, 2);
/*     */     } 
/*     */     
/*  93 */     i += this.size * 8 * 4;
/*     */     
/*  95 */     s.setDistance2Ground(0.0D).setHeight(2);
/*  96 */     (WORLD.ENTITIES()).caravans.caravan.render((SPRITE_RENDERER)r, i + this.path.dir().id(), x, y);
/*  97 */     (WORLD.ENTITIES()).caravans.caravan.render((SPRITE_RENDERER)s, i + this.path.dir().id(), x, y);
/*     */     
/*  99 */     int am = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     if (TIME.light().nightIs() && TIME.light().partOfCircular() * 16.0D > (this.destReg & 0x7)) {
/* 105 */       DIR d = this.path.dir();
/* 106 */       x += 8 * d.x();
/* 107 */       y += 8 * d.y();
/* 108 */       x += 16 + 4 - GAME.intervals().get05() % 8;
/* 109 */       y += 16 + 4 - GAME.intervals().get04() % 8;
/* 110 */       CORE.renderer().renderUniLight(x, y, 2, 128);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void render(SPRITE_RENDERER r, float ds, int x, int y) {
/* 115 */     int i = (int)(VIEW.renderSecond() * 2.0D) % 3;
/* 116 */     i *= 8;
/* 117 */     i += 32;
/* 118 */     (WORLD.ENTITIES()).caravans.caravan.render(r, i + DIR.SW.id(), x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderBelowTerrain(Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 130 */     this.path.move(this, speed * ds);
/* 131 */     if (!this.path.isValid()) {
/* 132 */       cancel();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 137 */     if (this.path.arrived()) {
/* 138 */       Region c = destination();
/* 139 */       if (c != null && Math.abs(this.path.x() - c.cx()) * Math.abs(this.path.y() - c.cy()) <= 1) {
/* 140 */         arrive();
/*     */         return;
/*     */       } 
/* 143 */       cancel();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cancel() {
/* 152 */     remove();
/*     */   }
/*     */   
/*     */   private void arrive() {
/* 156 */     Faction f = faction();
/* 157 */     if (f == null || f.capitolRegion() != destination()) {
/* 158 */       cancel();
/*     */       
/*     */       return;
/*     */     } 
/* 162 */     for (TRADABLE tt : TR.ALL()) {
/* 163 */       int am = this.payload[tt.index()];
/* 164 */       if (am != 0) {
/* 165 */         TRADE_TYPE t = (TRADE_TYPE)TRADE_TYPE.all.get(this.type);
/* 166 */         f.buyer(tt).addDeliver(am, t);
/* 167 */         this.payload[tt.index()] = 0;
/*     */       } 
/*     */     } 
/*     */     
/* 171 */     remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void add(int tx, int ty, Faction destination, TRADE_TYPE type) {
/* 182 */     for (int i = 0; i < this.payload.length; i++)
/* 183 */       this.payload[i] = 0; 
/* 184 */     body().moveX1Y1((tx * 64), (ty * 64));
/* 185 */     this.path.clear();
/* 186 */     this.destFaction = (short)destination.index();
/* 187 */     this.destReg = (short)destination.capitolRegion().index();
/*     */     
/* 189 */     this.path.find(tx, ty, destination.capitolRegion().cx(), destination.capitolRegion().cy());
/*     */     
/* 191 */     this.type = (byte)type.index;
/*     */     
/* 193 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 203 */     if (!(constructor()).free.isFull())
/* 204 */       (constructor()).free.push(this); 
/* 205 */     if (destination() == null) {
/*     */       return;
/*     */     }
/* 208 */     Faction f = faction();
/* 209 */     if (f == null || f.capitolRegion() != destination()) {
/*     */       return;
/*     */     }
/*     */     
/* 213 */     for (TRADABLE tt : TR.ALL()) {
/* 214 */       int am = this.payload[tt.index()];
/* 215 */       if (am != 0) {
/* 216 */         TRADE_TYPE t = type();
/* 217 */         f.buyer(tt).addDeliver(am, t);
/* 218 */         this.payload[tt.index()] = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Shipments constructor() {
/* 225 */     return (WORLD.ENTITIES()).caravans;
/*     */   }
/*     */   
/*     */   public TRADE_TYPE type() {
/* 229 */     return (TRADE_TYPE)TRADE_TYPE.all.get(this.type);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getZ() {
/* 234 */     return -1;
/*     */   }
/*     */   
/*     */   public Shipment load(TRADABLE r, int amount) {
/* 238 */     this.payload[r.index()] = CLAMP.i(amount + this.payload[r.index()], 0, 2147483647);
/* 239 */     this.size = -1;
/* 240 */     return this;
/*     */   }
/*     */   
/*     */   public Shipment loadAndReserve(TRADABLE r, int amount) {
/* 244 */     if (amount == 0)
/* 245 */       return this; 
/* 246 */     faction().buyer(r).addReserve(-this.payload[r.index()], type(), 0, null);
/* 247 */     this.payload[r.index()] = CLAMP.i(amount + this.payload[r.index()], 0, 2147483647);
/* 248 */     faction().buyer(r).addReserve(this.payload[r.index()], type(), 0, null);
/* 249 */     this.size = -1;
/* 250 */     return this;
/*     */   }
/*     */   
/*     */   public int loadGet(TRADABLE r) {
/* 254 */     return this.payload[r.index()];
/*     */   }
/*     */   
/*     */   public Region destination() {
/* 258 */     return WORLD.REGIONS().getByIndex(this.destReg);
/*     */   }
/*     */ 
/*     */   
/*     */   public WPath path() {
/* 263 */     return this.path;
/*     */   }
/*     */   
/*     */   private static class P
/*     */     extends WPath
/*     */   {
/*     */     public WRegFinder.Treaty treaty() {
/* 270 */       return WRegFinder.Treaty.DUMMY;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 277 */     return FACTIONS.getByIndex(this.destFaction);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\caravan\Shipment.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */