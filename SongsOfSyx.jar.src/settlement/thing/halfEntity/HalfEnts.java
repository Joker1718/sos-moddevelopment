/*     */ package settlement.thing.halfEntity;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.halfEntity.caravan.Caravans;
/*     */ import settlement.thing.halfEntity.dingy.DingyFactory;
/*     */ import settlement.thing.halfEntity.halfCorpse.MovingCorpseFactory;
/*     */ import settlement.thing.halfEntity.transport.TransportFactory;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public class HalfEnts
/*     */   extends SETT.SettResource
/*     */ {
/*     */   private final ArrayListResize<HalfEntity> ents;
/*     */   private final _WMap map;
/*  31 */   private final ArrayList<HalfEntity> tmp = new ArrayList(2056);
/*  32 */   private final ArrayList<Factory<?>> constructors = new ArrayList(20);
/*     */   
/*  34 */   public final Caravans caravans = new Caravans((LISTE)this.constructors);
/*  35 */   public final TransportFactory transports = new TransportFactory((LISTE)this.constructors);
/*  36 */   public final MovingCorpseFactory corpses = new MovingCorpseFactory((LISTE)this.constructors);
/*  37 */   public final DingyFactory dingy = new DingyFactory((LISTE)this.constructors);
/*  38 */   private final Tree<HalfEntity> renderables = new Tree<HalfEntity>(2056)
/*     */     {
/*     */       protected boolean isGreaterThan(HalfEntity current, HalfEntity cmp)
/*     */       {
/*  42 */         return (current.getZ() < cmp.getZ());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public HalfEnts() throws IOException {
/*  48 */     super("HALF_ENTS", true);
/*  49 */     this.ents = new ArrayListResize(1024, 64000);
/*  50 */     this.map = new _WMap(SETT.PWIDTH, SETT.PHEIGHT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  56 */     this.ents.clear();
/*  57 */     this.map.clear();
/*  58 */     for (Factory<?> f : this.constructors)
/*  59 */       f.clear(); 
/*  60 */     int am = file.i();
/*     */     
/*  62 */     for (int i = 0; i < am; i++) {
/*  63 */       int ci = file.i();
/*  64 */       Factory<?> c = (Factory)this.constructors.get(ci);
/*  65 */       HalfEntity e = (HalfEntity)c.create();
/*  66 */       e = e.load(file);
/*  67 */       e.hitBox.load(file);
/*  68 */       clear(e);
/*  69 */       e.index = this.ents.add(e);
/*  70 */       e.renderNext = null;
/*  71 */       this.map.add(e);
/*     */     } 
/*  73 */     for (Factory<?> f : this.constructors)
/*  74 */       f.load(file); 
/*     */   }
/*     */   
/*     */   private void clear(HalfEntity e) {
/*  78 */     e.index = -1;
/*  79 */     e.renderNext = null;
/*  80 */     e.gridX = -1;
/*  81 */     e.gridY = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  86 */     file.i(this.ents.size());
/*  87 */     for (HalfEntity e : this.ents) {
/*  88 */       file.i((e.constructor()).index);
/*  89 */       e.save(file);
/*  90 */       e.hitBox.save(file);
/*     */     } 
/*  92 */     for (Factory<?> f : this.constructors) {
/*  93 */       f.save(file);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void clear() {
/*  98 */     this.map.clear();
/*  99 */     for (HalfEntity e : this.ents)
/* 100 */       clear(e); 
/* 101 */     this.ents.clear();
/* 102 */     for (Factory<?> f : this.constructors)
/* 103 */       f.clear(); 
/*     */   }
/*     */   
/*     */   void add(HalfEntity e) {
/* 107 */     if (e.index != -1)
/* 108 */       throw new RuntimeException(); 
/* 109 */     int i = this.ents.add(e);
/* 110 */     clear(e);
/* 111 */     e.index = i;
/* 112 */     this.map.add(e);
/*     */   }
/*     */ 
/*     */   
/*     */   void remove(HalfEntity e) {
/* 117 */     if (e.index == -1)
/* 118 */       throw new RuntimeException(); 
/* 119 */     this.map.remove(e);
/*     */     
/* 121 */     HalfEntity e2 = (HalfEntity)this.ents.remove(this.ents.size() - 1);
/*     */     
/* 123 */     if (e2 != e) {
/* 124 */       this.ents.replace(e.index, e2);
/* 125 */       e2.index = e.index;
/*     */     } 
/* 127 */     clear(e);
/* 128 */     e.constructor().returnT(e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds, Profiler profiler) {
/* 135 */     for (int i = 0; i < this.ents.size(); i++) {
/* 136 */       HalfEntity e = (HalfEntity)this.ents.get(i);
/* 137 */       e.update(ds);
/* 138 */       if (!e.added()) {
/* 139 */         i--;
/*     */       } else {
/* 141 */         this.map.move(e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public LIST<HalfEntity> all() {
/* 146 */     return (LIST<HalfEntity>)this.ents;
/*     */   }
/*     */   
/*     */   public void fill(COORDINATE coo, LISTE<HalfEntity> result) {
/* 150 */     fill(coo.x(), coo.y(), result);
/*     */   }
/*     */   
/*     */   public void fill(int x, int y, LISTE<HalfEntity> result) {
/* 154 */     this.map.fill(x, x, y, y, result);
/*     */   }
/*     */   
/*     */   public void fill(int x1, int x2, int y1, int y2, LISTE<HalfEntity> result) {
/* 158 */     this.map.fill(x1, x2, y1, y2, result);
/*     */   }
/*     */   
/*     */   public HalfEntity getTallest(COORDINATE coo) {
/* 162 */     this.tmp.clear();
/* 163 */     fill(coo, (LISTE<HalfEntity>)this.tmp);
/* 164 */     HalfEntity tallest = null;
/* 165 */     double dist = Double.MAX_VALUE;
/* 166 */     for (HalfEntity e : this.tmp) {
/* 167 */       double d = coo.distance(e.body().cX(), e.body().cY());
/* 168 */       if (tallest == null || d < dist) {
/* 169 */         tallest = e;
/* 170 */         dist = d;
/*     */       } 
/*     */     } 
/* 173 */     return tallest;
/*     */   }
/*     */   
/*     */   public void renderInit(RECTANGLE renWindow) {
/* 177 */     this.renderables.clear();
/* 178 */     int min = 448;
/* 179 */     this.map.fill(renWindow.x1() - min, renWindow.x2() + min, renWindow.y1() - min, renWindow.y2() + min, this.renderables);
/* 180 */     this.tmp.clear();
/*     */ 
/*     */     
/* 183 */     while (this.renderables.hasMore()) {
/* 184 */       HalfEntity e = (HalfEntity)this.renderables.pollGreatest();
/* 185 */       this.tmp.add(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 192 */     offX -= renWindow.x1();
/* 193 */     offY -= renWindow.y1();
/*     */     
/* 195 */     for (HalfEntity e : this.tmp) {
/* 196 */       e.renderBelow(r, s, ds, e.body().x1() + offX, e.body().y1() + offY);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 203 */     offX -= renWindow.x1();
/* 204 */     offY -= renWindow.y1();
/*     */     
/* 206 */     COLOR.unbind();
/*     */ 
/*     */     
/* 209 */     for (HalfEntity e : this.tmp) {
/* 210 */       e.render(r, s, ds, e.body().x1() + offX, e.body().y1() + offY);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 217 */     offX -= renWindow.x1();
/* 218 */     offY -= renWindow.y1();
/*     */     
/* 220 */     for (HalfEntity e : this.tmp) {
/* 221 */       e.renderAbove(r, s, ds, e.body().x1() + offX, e.body().y1() + offY);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderZoomed(Renderer r, ShadowBatch shadowBatch, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 230 */     for (HalfEntity e : all()) {
/* 231 */       if (e == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 235 */       int x1 = e.body().cX();
/* 236 */       int y1 = e.body().cY();
/*     */ 
/*     */       
/* 239 */       if (!renWindow.holdsPoint(x1, y1))
/*     */         continue; 
/* 241 */       x1 -= renWindow.x1() - offX + 32;
/* 242 */       y1 -= renWindow.y1() - offY + 32;
/* 243 */       COLOR.BROWN.bind();
/* 244 */       (SPRITES.cons()).TINY.high.get(0).render((SPRITE_RENDERER)r, x1, y1);
/*     */     } 
/* 246 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\HalfEnts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */