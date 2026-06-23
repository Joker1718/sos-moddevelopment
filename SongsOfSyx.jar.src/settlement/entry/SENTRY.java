/*     */ package settlement.entry;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.rendering.RenderData;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class SENTRY extends SETT.SettResource {
/*     */   private final PeopleSpawner spawn;
/*     */   private final Immigration im;
/*     */   
/*     */   public SENTRY() {
/*  20 */     super("SENTRY", false);
/*     */ 
/*     */ 
/*     */     
/*  24 */     this.spawn = new PeopleSpawner();
/*  25 */     this.im = new Immigration();
/*  26 */     this.points = new EntryPoints();
/*  27 */     this.updater = new EntryUpdater();
/*     */   } public final EntryPoints points; private final EntryUpdater updater;
/*     */   public void add(Race race, HTYPE type, int amount) {
/*  30 */     if (amount <= 0)
/*     */       return; 
/*  32 */     this.spawn.add(race, type, amount);
/*     */   }
/*     */   
/*     */   public int onTheirWay(Race race, HTYPE type) {
/*  36 */     return this.spawn.onTheirWay(race, type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*  42 */     if (VIEW.b().isActive()) {
/*     */       return;
/*     */     }
/*  45 */     if (FACTIONS.player().capitolRegion() == null) {
/*     */       return;
/*     */     }
/*  48 */     this.points.update();
/*     */     
/*  50 */     this.updater.update(ds, this.points);
/*     */     
/*  52 */     if (isClosed()) {
/*  53 */       this.spawn.update(0.0D);
/*  54 */       this.im.update(0.0D);
/*     */     } else {
/*  56 */       this.spawn.update(ds);
/*  57 */       this.im.update(ds);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, RenderData renData) {
/*  63 */     this.points.render(r, renData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  70 */     this.updater.save(file);
/*  71 */     this.points.saver.save(file);
/*  72 */     this.spawn.save(file);
/*  73 */     this.im.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  78 */     this.updater.load(file);
/*  79 */     this.points.saver.load(file);
/*  80 */     this.spawn.load(file);
/*  81 */     this.im.saver.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  86 */     this.updater.clear();
/*  87 */     this.points.saver.clear();
/*  88 */     this.spawn.clear();
/*  89 */     this.im.saver.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(boolean loaded) {}
/*     */ 
/*     */   
/*     */   public Immigration immi() {
/*  98 */     return this.im;
/*     */   }
/*     */   
/*     */   public boolean isClosed() {
/* 102 */     return !(!this.updater.isClosed() && !SETT.INVADOR().invading());
/*     */   }
/*     */   
/*     */   public boolean beseiged() {
/* 106 */     return this.updater.beseiged();
/*     */   }
/*     */   
/*     */   public double besigeTime() {
/* 110 */     return this.updater.besigeTime();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\SENTRY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */