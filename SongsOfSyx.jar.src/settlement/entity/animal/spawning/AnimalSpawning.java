/*     */ package settlement.entity.animal.spawning;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.entity.animal.Animals;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ public final class AnimalSpawning
/*     */ {
/*  20 */   private final ArrayList<AnimalSpawnSpot> spots = new ArrayList(16); public static final double SPAWN_RATE_DAY = 0.01D;
/*     */   
/*  22 */   private final IUpdater uper = new IUpdater(16, TIME.secondsPerDay())
/*     */     {
/*     */       protected void update(int i, double timeSinceLast) {
/*  25 */         AnimalSpawnSpot sp = (AnimalSpawnSpot)AnimalSpawning.this.spots.get(i);
/*  26 */         if (sp.active())
/*  27 */           AnimalSpawning.this.max -= sp.max(); 
/*  28 */         sp.update(0.01D);
/*  29 */         if (sp.active())
/*  30 */           AnimalSpawning.this.max += sp.max(); 
/*     */       }
/*     */     };
/*  33 */   private int max = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private final double[] killed;
/*     */ 
/*     */   
/*     */   public final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/*  45 */     this.uper.update(ds);
/*     */   }
/*     */   
/*     */   public int spawnsPerDay() {
/*  49 */     return (int)Math.ceil(this.max * 0.01D);
/*     */   }
/*     */   
/*     */   public void generate(Animals animals, CapitolArea carea) {
/*  53 */     this.saver.clear();
/*     */     
/*  55 */     for (AnimalSpawnSpot s : this.spots)
/*  56 */       this.max += s.max(); 
/*     */   }
/*     */   
/*     */   public AnimalSpawning(Animals animals) {
/*  60 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  64 */           for (AnimalSpawnSpot s : AnimalSpawning.this.spots)
/*  65 */             s.save(file); 
/*  66 */           AnimalSpawning.this.uper.save(file);
/*  67 */           (SETT.ANIMALS()).map.saver().save(AnimalSpawning.this.killed, file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  72 */           clear();
/*  73 */           for (AnimalSpawnSpot s : AnimalSpawning.this.spots) {
/*  74 */             s.load(file);
/*  75 */             AnimalSpawning.this.max += s.max();
/*     */           } 
/*  77 */           AnimalSpawning.this.uper.load(file);
/*  78 */           (SETT.ANIMALS()).map.loader().load(AnimalSpawning.this.killed, file, 0.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void clear() {
/*  84 */           for (AnimalSpawnSpot s : AnimalSpawning.this.spots)
/*  85 */             s.clear(); 
/*  86 */           AnimalSpawning.this.uper.clear();
/*  87 */           AnimalSpawning.this.max = 0;
/*  88 */           Arrays.fill(AnimalSpawning.this.killed, 0.0D); }
/*     */       };
/*     */     for (int i = 0; i < this.spots.max(); i++)
/*     */       this.spots.add(new AnimalSpawnSpot(i)); 
/*     */     this.killed = new double[animals.species.size()]; } public LIST<AnimalSpawnSpot> all() {
/*  93 */     return (LIST<AnimalSpawnSpot>)this.spots;
/*     */   }
/*     */   
/*     */   public boolean isTimeForAKill(AnimalSpecies s) {
/*  97 */     return (this.killed[s.index()] / 4.0D >= 1.0D);
/*     */   }
/*     */   
/*     */   public void reportKilled(AnimalSpecies s) {
/* 101 */     this.killed[s.index()] = this.killed[s.index()] + s.danger;
/*     */   }
/*     */   
/*     */   public void reportKillRevenge(AnimalSpecies s) {
/* 105 */     this.killed[s.index()] = 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\spawning\AnimalSpawning.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */