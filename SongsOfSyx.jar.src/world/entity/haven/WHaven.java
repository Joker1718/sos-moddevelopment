/*     */ package world.entity.haven;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.WEntityConstructor;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public class WHaven
/*     */   extends WEntity {
/*  21 */   private int ti = 0;
/*     */   private double size;
/*     */   private int ran;
/*  24 */   public final Str name = new Str(16);
/*     */   
/*     */   public WHaven() {
/*  27 */     super(96, 96);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  32 */     file.i(this.ti);
/*  33 */     file.d(this.size);
/*  34 */     file.i(this.ran);
/*  35 */     this.name.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WEntity load(FileGetter file) throws IOException {
/*  40 */     this.ti = file.i();
/*  41 */     this.ti = CLAMP.i(this.ti, 0, (WORLD.camps()).types.size() - 1);
/*  42 */     this.size = file.d();
/*  43 */     this.ran = file.i();
/*  44 */     this.name.load(file);
/*  45 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderAboveTerrain(Renderer r, ShadowBatch s, float ds, int x, int y) {
/*  51 */     WHavenType t = type();
/*     */     
/*  53 */     int off = (t.sheet.size() - 96) / 2;
/*     */     
/*  55 */     int ran = (this.ran & 0x3) * 8;
/*  56 */     ran += ran >> 2 & 0x1;
/*  57 */     int size = (int)Math.ceil(this.size * 3.0D) * 2;
/*  58 */     t.cMask.bind();
/*  59 */     t.sheet.render((SPRITE_RENDERER)r, ran + size, x - off, y - off);
/*  60 */     s.setHeight(4).setDistance2Ground(0.0D);
/*  61 */     t.sheet.render((SPRITE_RENDERER)s, ran + size, x - off, y - off);
/*     */     
/*  63 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public void add(int tx, int ty, WHavenType type, double size, CharSequence name) {
/*  67 */     this.ti = type.index();
/*  68 */     this.ran = RND.rInt();
/*  69 */     this.name.clear().add(name);
/*  70 */     this.size = size;
/*  71 */     body().moveC((tx * 64 + 32), (ty * 64 + 32));
/*     */     
/*  73 */     add();
/*     */   }
/*     */   
/*     */   public WHavenType type() {
/*  77 */     return (WHavenType)(constructor()).types.get(this.ti);
/*     */   }
/*     */   
/*     */   public int pop() {
/*  81 */     return (int)Math.ceil((type()).popFrom + ((type()).popTo - (type()).popFrom) * this.size);
/*     */   }
/*     */   
/*     */   public double replenish() {
/*  85 */     return (type()).replenishMin + ((type()).replenishMax - (type()).replenishMin) * this.size;
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
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WHavens constructor() {
/* 102 */     return (WORLD.ENTITIES()).havens;
/*     */   }
/*     */   
/*     */   public void delete() {
/* 106 */     remove();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addAction() {
/* 111 */     Region r = (Region)(WORLD.REGIONS()).map.get(ctx(), cty());
/* 112 */     if (r != null)
/* 113 */       (WORLD.ENTITIES()).havens.setDirty(r.faction()); 
/* 114 */     super.addAction();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 119 */     Region r = (Region)(WORLD.REGIONS()).map.get(ctx(), cty());
/* 120 */     if (r != null)
/* 121 */       (WORLD.ENTITIES()).havens.setDirty(r.faction()); 
/* 122 */     if (!(constructor()).free.isFull()) {
/* 123 */       (constructor()).free.push(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public Faction faction() {
/* 128 */     Region r = (Region)(WORLD.REGIONS()).map.get(ctx(), cty());
/* 129 */     if (r != null)
/* 130 */       return r.faction(); 
/* 131 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\WHaven.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */