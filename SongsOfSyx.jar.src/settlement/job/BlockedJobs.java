/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.Dic;
/*     */ import util.updating.IUpdater;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ 
/*     */ public class BlockedJobs
/*     */   implements SAVABLE
/*     */ {
/*  37 */   private final BlockedJob[] all = new BlockedJob[16];
/*  38 */   private final ArrayList<BlockedJob> active = new ArrayList(this.all.length);
/*  39 */   private final ArrayList<BlockedJob> free = new ArrayList(this.all.length);
/*  40 */   private int upI = -1;
/*  41 */   private final IUpdater uper = new IUpdater(SETT.TAREA, TIME.secondsPerDay())
/*     */     {
/*     */       protected void update(int i, double timeSinceLast)
/*     */       {
/*  45 */         if (BlockedJobs.this.free.size() == 0) {
/*     */           return;
/*     */         }
/*  48 */         Job job = (Job)(SETT.JOBS()).getter.get(i);
/*  49 */         if (job == null) {
/*     */           return;
/*     */         }
/*  52 */         if (job instanceof JobClear) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*  57 */         int tx = i % SETT.TWIDTH;
/*  58 */         int ty = i / SETT.THEIGHT;
/*  59 */         if ((SETT.PATH()).reachability.is(tx, ty)) {
/*     */           return;
/*     */         }
/*  62 */         if ((SETT.JOBS()).state.get(tx, ty) == StateManager.State.DORMANT) {
/*     */           return;
/*     */         }
/*  65 */         if (job.jobResourceBitToFetch() != null && !job.jobResourceBitToFetch().isClear() && !(SETT.PATH()).finders.resource.has(THRONE.coo().x(), THRONE.coo().y(), job.jobResourceBitToFetch())) {
/*     */           return;
/*     */         }
/*  68 */         for (BlockedJobs.BlockedJob j : BlockedJobs.this.active) {
/*  69 */           if (j.blocked.isSameAs(tx, ty)) {
/*     */             return;
/*     */           }
/*     */         } 
/*  73 */         PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */         
/*  75 */         f.init(this);
/*  76 */         f.pushSloppy(tx, ty, 0.0D);
/*  77 */         while (f.hasMore()) {
/*  78 */           PathTile t = GUTIL.flooder().pollSmallest();
/*     */           
/*  80 */           if (t.getValue() > 16.0F) {
/*     */             break;
/*     */           }
/*  83 */           if ((SETT.PATH()).reachability.is((COORDINATE)t)) {
/*  84 */             BlockedJobs.BlockedJob j = (BlockedJobs.BlockedJob)BlockedJobs.this.free.removeLast();
/*  85 */             j.blocked.set(tx, ty);
/*  86 */             j.coo.set((COORDINATE)t);
/*  87 */             BlockedJobs.this.active.add(j);
/*  88 */             f.done();
/*     */             
/*     */             return;
/*     */           } 
/*  92 */           for (DIR d : DIR.ALL) {
/*  93 */             if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/*  94 */               f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 101 */         f.done();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockedJobs() {
/* 113 */     for (int i = 0; i < this.all.length; i++) {
/* 114 */       this.all[i] = new BlockedJob(i);
/* 115 */       this.free.add(this.all[i]);
/*     */     } 
/* 117 */     while (this.free.hasRoom()) {
/* 118 */       this.free.add(new BlockedJob(this.free.size()));
/*     */     }
/* 120 */     IDebugPanelSett.add("BLOCKED_JOB PERFORM", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 124 */             BlockedJobs.BlockedJob j = BlockedJobs.this.next();
/* 125 */             LOG.ln(j);
/* 126 */             if (j != null) {
/* 127 */               LOG.ln(String.valueOf(j.coo) + "  " + String.valueOf(j.coo));
/*     */               
/* 129 */               RBIT bb = j.jobResourceBitToFetch();
/* 130 */               RESOURCE res = null;
/* 131 */               if (bb != null) {
/* 132 */                 for (RESOURCE r : RESOURCES.ALL()) {
/* 133 */                   if (bb.has(r)) {
/* 134 */                     res = r;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               }
/* 139 */               if (j.jobReserveCanBe()) {
/* 140 */                 j.jobReserve(res);
/*     */               }
/* 142 */               j.jobPerform(null, res, 1);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockedJob next() {
/* 150 */     if (this.upI != GAME.updateI()) {
/* 151 */       for (BlockedJob j : this.active) {
/* 152 */         if (!isActive(j, true)) {
/* 153 */           Job job = (Job)(SETT.JOBS()).getter.get((COORDINATE)j.blocked);
/* 154 */           if (job != null) {
/* 155 */             job.jobReserveCancel((RESOURCE)null);
/*     */           }
/* 157 */           this.active.remove(j);
/* 158 */           this.free.add(j);
/* 159 */           return null;
/* 160 */         }  if (j.jobReserveCanBe())
/* 161 */           return j; 
/*     */       } 
/* 163 */       this.upI = GAME.updateI();
/*     */     } 
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   public BlockedJob getByRef(int id) {
/* 169 */     BlockedJob j = this.all[id];
/* 170 */     if (isActive(j, false))
/* 171 */       return j; 
/* 172 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isActive(BlockedJob j, boolean res) {
/* 177 */     Job job = (Job)(SETT.JOBS()).getter.get((COORDINATE)j.blocked);
/* 178 */     if (job == null)
/* 179 */       return false; 
/* 180 */     if (!job.becomesSolid()) {
/* 181 */       return false;
/*     */     }
/* 183 */     if ((SETT.PATH()).reachability.is((COORDINATE)j.blocked))
/* 184 */       return false; 
/* 185 */     if ((SETT.JOBS()).state.get((COORDINATE)j.blocked) == StateManager.State.DORMANT)
/* 186 */       return false; 
/* 187 */     if (!(SETT.PATH()).reachability.is((COORDINATE)j.coo))
/* 188 */       return false; 
/* 189 */     if (res && 
/* 190 */       job.jobResourceBitToFetch() != null && !job.jobResourceBitToFetch().isClear() && !(SETT.PATH()).finders.resource.has(THRONE.coo().x(), THRONE.coo().y(), job.jobResourceBitToFetch())) {
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 199 */     if (this.free.size() == 0)
/*     */       return; 
/* 201 */     this.uper.update(ds);
/*     */   }
/*     */   
/*     */   public final class BlockedJob
/*     */     implements SETT_JOB {
/* 206 */     private final Coo coo = new Coo();
/* 207 */     private final Coo blocked = new Coo();
/*     */     public final int ID;
/*     */     
/*     */     private BlockedJob(int id) {
/* 211 */       this.ID = id;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 216 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 217 */       if (j != null) {
/* 218 */         j.jobReserve(r);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 223 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 224 */       if (j != null)
/* 225 */         return j.jobReservedIs(r); 
/* 226 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 231 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 232 */       if (j != null) {
/* 233 */         j.jobReserveCancel(r);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean jobReserveCanBe() {
/* 238 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 239 */       if (j != null)
/* 240 */         return j.jobReserveCanBe(); 
/* 241 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 246 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 247 */       if (j != null) {
/* 248 */         return j.jobResourceBitToFetch();
/*     */       }
/* 250 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int jobResourcesNeeded(Humanoid skill) {
/* 255 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 256 */       if (j != null) {
/* 257 */         return j.jobResourcesNeeded(skill);
/*     */       }
/* 259 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid a) {
/* 264 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 265 */       if (j != null) {
/* 266 */         return j.jobPerformTime(a);
/*     */       }
/* 268 */       return 1.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 278 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 279 */       if (j != null) {
/* 280 */         return j.jobPerform(skill, r, rAm);
/*     */       }
/* 282 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 287 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence jobName() {
/* 292 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 293 */       if (j != null)
/* 294 */         return j.jobName(); 
/* 295 */       return Dic.empty;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 300 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 301 */       if (j != null)
/* 302 */         return j.jobUseTool(); 
/* 303 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 308 */       Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 309 */       if (j != null)
/* 310 */         return j.jobSound(); 
/* 311 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 318 */     this.uper.save(file);
/* 319 */     for (BlockedJob j : this.active) {
/* 320 */       file.i(j.ID);
/* 321 */       j.coo.save(file);
/* 322 */       j.blocked.save(file);
/* 323 */       file.bool(true);
/*     */     } 
/* 325 */     for (BlockedJob j : this.free) {
/* 326 */       file.i(j.ID);
/* 327 */       j.coo.save(file);
/* 328 */       j.blocked.save(file);
/* 329 */       file.bool(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 336 */     this.uper.load(file);
/* 337 */     this.active.clearSloppy();
/* 338 */     this.free.clearSloppy();
/* 339 */     for (int i = 0; i < this.all.length; i++) {
/* 340 */       BlockedJob j = this.all[file.i()];
/* 341 */       j.coo.load(file);
/* 342 */       j.blocked.load(file);
/* 343 */       if (file.bool()) {
/* 344 */         this.active.add(j);
/*     */       } else {
/* 346 */         this.free.add(j);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 354 */     this.active.clearSloppy();
/* 355 */     this.free.clearSloppy(); byte b; int i; BlockedJob[] arrayOfBlockedJob;
/* 356 */     for (i = (arrayOfBlockedJob = this.all).length, b = 0; b < i; ) { BlockedJob j = arrayOfBlockedJob[b];
/* 357 */       this.free.add(j);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\BlockedJobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */