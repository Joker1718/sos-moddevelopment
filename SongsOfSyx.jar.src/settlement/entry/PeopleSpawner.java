/*     */ package settlement.entry;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.INT_O;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ 
/*     */ final class PeopleSpawner
/*     */   implements SAVABLE
/*     */ {
/*  30 */   private int rspot = RND.rInt();
/*     */   
/*     */   private double time;
/*     */   
/*     */   private int ri;
/*     */   private int ti;
/*  36 */   private final IM[] onTheirWay = new IM[RACES.all().size()];
/*  37 */   private final IM onTotal = new IM();
/*     */   
/*     */   public PeopleSpawner() {
/*  40 */     IDebugPanelSett.add("Spawn immigrants", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  44 */             PeopleSpawner.this.add(FACTIONS.player().race(), HTYPES.SUBJECT(), 100);
/*     */           }
/*     */         });
/*  47 */     for (int i = 0; i < this.onTheirWay.length; i++) {
/*  48 */       this.onTheirWay[i] = new IM();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  54 */     RACES.map().saver().save((SAVABLE[])this.onTheirWay, file);
/*  55 */     this.onTotal.save(file);
/*  56 */     file.i(this.rspot);
/*  57 */     file.i(this.ri);
/*  58 */     file.i(this.ti);
/*  59 */     file.d(this.time);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  66 */     RACES.map().loader().load((SAVABLE[])this.onTheirWay, file);
/*  67 */     this.onTotal.load(file);
/*  68 */     this.rspot = file.i();
/*  69 */     this.ri = file.i();
/*  70 */     this.ti = file.i();
/*  71 */     this.time = file.d();
/*     */   } public void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     IM[] arrayOfIM;
/*  76 */     for (i = (arrayOfIM = this.onTheirWay).length, b = 0; b < i; ) { IM is = arrayOfIM[b];
/*  77 */       is.clear(); b++; }
/*  78 */      this.onTotal.clear();
/*     */   }
/*     */   
/*     */   public int onTheirWay(Race race, HTYPE type) {
/*  82 */     IM ii = (race == null) ? this.onTotal : this.onTheirWay[race.index()];
/*  83 */     return ii.get(type);
/*     */   }
/*     */   
/*     */   public void add(Race race, HTYPE type, int amount) {
/*  87 */     if (amount > 32767)
/*  88 */       throw new RuntimeException(); 
/*  89 */     if (amount < 0)
/*     */       return; 
/*  91 */     this.onTotal.inc(type, amount);
/*  92 */     this.onTheirWay[race.index()].inc(type, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  97 */     if (this.onTotal.tot() == 0) {
/*     */       return;
/*     */     }
/* 100 */     if ((SETT.ENTRY()).points.reachable().size() == 0) {
/*     */       return;
/*     */     }
/* 103 */     this.time += ds;
/* 104 */     int rr = RACES.all().size();
/* 105 */     while (this.time > 0.0D && rr-- > 0) {
/* 106 */       this.ri %= RACES.all().size();
/* 107 */       IM aa = this.onTheirWay[this.ri];
/* 108 */       if (aa.tot() > 0) {
/* 109 */         for (int i = 0; i < HTYPES.ALL().size(); i++) {
/* 110 */           this.ti %= HTYPES.ALL().size();
/* 111 */           HTYPE tt = (HTYPE)HTYPES.ALL().get(this.ti);
/* 112 */           if (aa.get(tt) > 0) {
/* 113 */             COORDINATE c = (SETT.ENTRY()).points.randomReachable(this.rspot);
/* 114 */             if (c == null) {
/*     */               return;
/*     */             }
/* 117 */             spawn(c, (Race)RACES.all().get(this.ri), (HTYPE)HTYPES.ALL().get(this.ti));
/* 118 */             this.time--;
/* 119 */             if (this.time < 0.0D)
/*     */               return; 
/*     */           } else {
/* 122 */             this.ti++;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 127 */       this.rspot = RND.rInt();
/* 128 */       this.ti = 0;
/* 129 */       this.ri++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean spawn(COORDINATE spot, Race r, HTYPE t) {
/* 137 */     DIR d = DIR.get(SETT.TWIDTH / 2, SETT.THEIGHT / 2, spot.x(), spot.y()).next(2);
/* 138 */     if (!d.isOrtho()) {
/* 139 */       d = d.next((int)(1.0D * RND.rSign()));
/*     */     }
/* 141 */     int tx = spot.x() + d.x() * RND.rInt(6);
/* 142 */     int ty = spot.y() + d.y() * RND.rInt(6);
/* 143 */     for (int dd = 0; dd <= 6; dd++) {
/* 144 */       if ((SETT.PATH()).connectivity.is(tx, ty)) {
/*     */ 
/*     */         
/* 147 */         Humanoid h = SETT.HUMANOIDS().create(r, tx, ty, t, CAUSE_ARRIVES.IMMIGRATED());
/* 148 */         init(h);
/*     */         
/* 150 */         if (t == HTYPES.PRISONER()) {
/* 151 */           (STATS.LAW()).prisonerType.set(h.indu(), CRIMES.WAR());
/*     */         }
/*     */         
/* 154 */         this.onTheirWay[r.index].inc(t, -1);
/* 155 */         this.onTotal.inc(t, -1);
/*     */         
/* 157 */         return true;
/*     */       } 
/* 159 */       tx -= d.x();
/* 160 */       ty -= d.y();
/*     */     } 
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   private void init(Humanoid h) {
/* 166 */     if (h == null || !(h.indu().clas()).player) {
/*     */       return;
/*     */     }
/* 169 */     STATS.Arrive(h);
/*     */   }
/*     */   
/*     */   private static class IM implements SAVABLE, INT_O.INT_OE<HTYPE> { private int tot;
/*     */     private final int[] pam;
/*     */     
/*     */     private IM() {
/* 176 */       this.pam = Alloc.ii(HTYPES.ALL().size());
/*     */     }
/*     */     
/*     */     public void save(FilePutter file) {
/* 180 */       HTYPES.MAP().saver().save(this.pam, file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 185 */       HTYPES.MAP().loader().load(this.pam, file, 0);
/* 186 */       this.tot = 0; byte b; int i, arrayOfInt[];
/* 187 */       for (i = (arrayOfInt = this.pam).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 188 */         this.tot += j;
/*     */         b++; }
/*     */     
/*     */     }
/*     */     public void clear() {
/* 193 */       this.tot = 0;
/* 194 */       Arrays.fill(this.pam, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(HTYPE t) {
/* 199 */       if (t == null)
/* 200 */         return this.tot; 
/* 201 */       return this.pam[t.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(HTYPE t) {
/* 206 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(HTYPE t) {
/* 211 */       return Integer.MAX_VALUE;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(HTYPE t, int i) {
/* 216 */       this.tot -= this.pam[t.index()];
/* 217 */       this.pam[t.index()] = i;
/* 218 */       this.tot += this.pam[t.index()];
/*     */     }
/*     */     
/*     */     public int tot() {
/* 222 */       return this.tot;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\PeopleSpawner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */