/*     */ package game.values;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class GCOUNTS
/*     */   extends GAME.GameResource
/*     */ {
/*  33 */   private LinkedList<SAccumilator> all = new LinkedList();
/*     */   
/*     */   public final SAccumilator ENSLAVED;
/*     */   
/*     */   public final SAccumilator FREED_SLAVES;
/*     */   
/*     */   public final SAccumilator TIME_PLAYED;
/*     */   
/*     */   public final SAccumilator TRADE_SALES;
/*     */   
/*     */   public final SAccumilator TRADE_PURCHASES;
/*     */   
/*     */   public final SAccumilator RIOTS;
/*     */   
/*     */   public final SAccumilator CRAFTED;
/*     */   
/*     */   public final SAccumilator INVASIONS;
/*     */   
/*     */   public final SAccumilator EXECUTIONS;
/*     */   
/*     */   public final SAccumilator TUNNELS;
/*     */   
/*     */   public final SAccumilator ROOMS_BUILT;
/*     */   
/*     */   public final SAccumilator SUBJECTS;
/*     */   public final SAccumilator INVASIONS_WON;
/*     */   public final SAccumilator INVASIONS_LOST;
/*     */   public final SAccumilator ROYALTIES_KILLED;
/*     */   public final SAccumilator CURED;
/*     */   public final SAccumilator ACCIDENTS;
/*     */   public final SAccumilator UNITES;
/*     */   public final LIST<SAccumilator> ALL;
/*     */   public final RMAPS<SAccumilator> MAP;
/*     */   private static final String filename = "StatsDoNotCheat";
/*  67 */   private static CharSequence ¤¤allTime = "¤all time";
/*     */   
/*     */   private final int[] trashold;
/*     */   private final int[] hi;
/*     */   private final int[] value;
/*     */   
/*     */   static {
/*  74 */     D.ts(GCOUNTS.class);
/*     */   }
/*     */   
/*     */   public GCOUNTS() {
/*  78 */     super("COUNTS", true); D.gInit(this); this.ENSLAVED = new SAccumilator((LISTE<SAccumilator>)this.all, "ENSLAVED", true, D.g("ENSLAVED", "Enslaved Population")); this.FREED_SLAVES = new SAccumilator((LISTE<SAccumilator>)this.all, "FREED_SLAVES", true, D.g("FREED_SLAVES", "Slaves Freed")); this.TIME_PLAYED = new SAccumilator((LISTE<SAccumilator>)this.all, "TIME_PLAYED", true, D.g("TIME_PLAYED", "Time Played")); this.TRADE_SALES = new SAccumilator((LISTE<SAccumilator>)this.all, "TRADE_SALES", true, D.g("TRADE_SALES", "Denari from sales")); this.TRADE_PURCHASES = new SAccumilator((LISTE<SAccumilator>)this.all, "TRADE_PURCHASES", true, D.g("TRADE_PURCHASES", "Denari from purchases")); this.RIOTS = new SAccumilator((LISTE<SAccumilator>)this.all, "RIOTS", true, D.g("RIOTS", "Riots")); this.CRAFTED = new SAccumilator((LISTE<SAccumilator>)this.all, "CRAFTED", true, D.g("CRAFTED", "Goods Crafted")); this.INVASIONS = new SAccumilator((LISTE<SAccumilator>)this.all, "INVASIONS", true, D.g("INVASIONS", "Invasions")); this.EXECUTIONS = new SAccumilator((LISTE<SAccumilator>)this.all, "EXECUTIONS", true, D.g("EXECUTIONS", "Executions")); this.TUNNELS = new SAccumilator((LISTE<SAccumilator>)this.all, "TUNNELS", true, D.g("TUNNELS", "Tunnels dug")); this.ROOMS_BUILT = new SAccumilator((LISTE<SAccumilator>)this.all, "ROOMS_BUILT", false, D.g("ENSLAVED", "Rooms built")); this.SUBJECTS = new SAccumilator((LISTE<SAccumilator>)this.all, "SUBJECTS", false, D.g("SUBJECTS", "Population")); this.INVASIONS_WON = new SAccumilator((LISTE<SAccumilator>)this.all, "INVASIONS_WON", false, D.g("INVASIONS_WON", "Invasions Won")); this.INVASIONS_LOST = new SAccumilator((LISTE<SAccumilator>)this.all, "INVASIONS_LOST", false, D.g("INVASIONS_LOST", "Invasions Lost")); this.ROYALTIES_KILLED = new SAccumilator((LISTE<SAccumilator>)this.all, "ROYALTIES_KILLED", false, D.g("ROYALTIES_KILLED", "Royalties assassinated")); this.CURED = new SAccumilator((LISTE<SAccumilator>)this.all, "HOSPITAL_CURED", false, D.g("HOSPITAL_CURED", "Cured")); this.ACCIDENTS = new SAccumilator((LISTE<SAccumilator>)this.all, "ACCIDENTS", false, D.g("ACCIDENTS", "Accidents")); this.UNITES = new SAccumilator((LISTE<SAccumilator>)this.all, "UNITES", false, D.g("UNITES", "Kingdoms united")); this.ALL = (LIST<SAccumilator>)new ArrayList((Iterable)this.all);
/*  79 */     this.all = null;
/*     */ 
/*     */     
/*  82 */     this.trashold = Alloc.ii(this.ALL.size());
/*  83 */     this.hi = Alloc.ii(this.ALL.size());
/*  84 */     this.value = Alloc.ii(this.ALL.size());
/*     */     
/*  86 */     this.MAP = new RMAPS("STATISTIC", this.ALL);
/*  87 */     read();
/*     */     
/*  89 */     GVALUES.FACTION.push("WORLD_REGIONS", Dic.¤¤Regions, (SPRITE)(UI.icons()).s.world, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  93 */             return t.realm().regions();
/*     */           }
/*     */         }, 
/*  96 */         false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void read() {
/*     */     try {
/* 104 */       Arrays.fill(this.value, 0);
/* 105 */       Arrays.fill(this.trashold, 0);
/* 106 */       Arrays.fill(this.hi, 0);
/* 107 */       Json json = new Json((PATHS.local()).PROFILE.gets("StatsDoNotCheat"));
/* 108 */       for (SAccumilator s : this.ALL) {
/* 109 */         this.trashold[s.index] = 0;
/* 110 */         this.hi[s.index] = 0;
/* 111 */         if (json.has(s.key)) {
/* 112 */           this.trashold[s.index] = json.i(s.key);
/*     */         }
/* 114 */         if (json.has(s.key + "_HIGH"))
/* 115 */           this.hi[s.index] = json.i(s.key + "_HIGH"); 
/*     */       } 
/* 117 */     } catch (Exception e) {
/* 118 */       e.printStackTrace(System.out);
/* 119 */       for (SAccumilator s : this.ALL) {
/* 120 */         this.trashold[s.index] = 0;
/* 121 */         this.hi[s.index] = 0;
/*     */       } 
/*     */       try {
/* 124 */         JsonE j = new JsonE();
/* 125 */         for (SAccumilator s : this.ALL) {
/* 126 */           j.add(s.key, 0);
/*     */         }
/* 128 */         if (!(PATHS.local()).PROFILE.exists("StatsDoNotCheat"))
/* 129 */           (PATHS.local()).PROFILE.create("StatsDoNotCheat"); 
/* 130 */         j.save((PATHS.local()).PROFILE.get("StatsDoNotCheat"));
/* 131 */       } catch (Exception ee) {
/* 132 */         ee.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void flush() {
/* 138 */     if (!GAME.achieving()) {
/*     */       return;
/*     */     }
/*     */     try {
/* 142 */       JsonE j = new JsonE();
/* 143 */       for (SAccumilator s : this.ALL) {
/* 144 */         j.add(s.key, CLAMP.i(s.allTimeHigh(), 0, 2147483647));
/* 145 */         j.add(s.key + "_HIGH", CLAMP.i(s.allTimeHigh(), 0, 2147483647));
/*     */       } 
/* 147 */       if (!(PATHS.local()).PROFILE.exists("StatsDoNotCheat"))
/* 148 */         (PATHS.local()).PROFILE.create("StatsDoNotCheat"); 
/* 149 */       j.save((PATHS.local()).PROFILE.get("StatsDoNotCheat"));
/* 150 */     } catch (Exception e) {
/* 151 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Json getJson() {
/* 156 */     if ((PATHS.local()).PROFILE.exists("StatsDoNotCheat"))
/* 157 */       return new Json((PATHS.local()).PROFILE.gets("StatsDoNotCheat")); 
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 163 */     this.MAP.saver().save(this.hi, file);
/* 164 */     this.MAP.saver().save(this.trashold, file);
/* 165 */     this.MAP.saver().save(this.value, file);
/* 166 */     flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 172 */     read();
/* 173 */     int[] hi = Alloc.ii(this.ALL.size());
/* 174 */     this.MAP.loader().load(hi, file, 0);
/* 175 */     this.MAP.loader().load(hi, file, 0);
/* 176 */     this.MAP.loader().load(this.value, file, 0);
/* 177 */     for (int i = 0; i < hi.length; i++) {
/* 178 */       this.hi[i] = this.hi[i] - hi[i];
/* 179 */       if (this.hi[i] < 0) {
/* 180 */         this.hi[i] = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 186 */     this.TIME_PLAYED.set((int)(TIME.playedGame() / 60.0D));
/*     */   }
/*     */   
/*     */   public final class SAccumilator
/*     */     implements MAPPED {
/*     */     public final String key;
/*     */     private final boolean isBattle;
/*     */     private final int index;
/*     */     public final CharSequence name;
/*     */     
/*     */     SAccumilator(LISTE<SAccumilator> all, String key, boolean isBattle, CharSequence name) {
/* 197 */       this.index = all.add(this);
/* 198 */       this.key = "COUNT_" + key;
/* 199 */       this.isBattle = isBattle;
/* 200 */       this.name = name;
/* 201 */       GVALUES.FACTION.push(this.key + "_GAME", name, (SPRITE)(UI.icons()).s.pluses, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t)
/*     */             {
/* 205 */               return GCOUNTS.SAccumilator.this.current();
/*     */             }
/* 207 */           },  false);
/* 208 */       GVALUES.FACTION.push(this.key + "_ALL_TIME", String.valueOf(name) + " (" + String.valueOf(name) + ")", (SPRITE)(UI.icons()).s.pluses, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t)
/*     */             {
/* 212 */               return GCOUNTS.SAccumilator.this.allTimeHigh();
/*     */             }
/* 214 */           },  false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void inc(int delta) {
/* 220 */       if (this.isBattle || !VIEW.b().isActive()) {
/* 221 */         GCOUNTS.this.value[this.index] = GCOUNTS.this.value[this.index] + delta;
/* 222 */         GCOUNTS.this.value[this.index] = GCOUNTS.this.value[this.index] & Integer.MAX_VALUE;
/* 223 */         GCOUNTS.this.hi[this.index] = GCOUNTS.this.hi[this.index] + delta;
/* 224 */         GCOUNTS.this.hi[this.index] = GCOUNTS.this.hi[this.index] & Integer.MAX_VALUE;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void set(int a) {
/* 229 */       if (this.isBattle || !VIEW.b().isActive()) {
/* 230 */         GCOUNTS.this.value[this.index] = a;
/* 231 */         GCOUNTS.this.value[this.index] = GCOUNTS.this.value[this.index] & Integer.MAX_VALUE;
/* 232 */         if (GCOUNTS.this.value[this.index] > GCOUNTS.this.hi[this.index]) {
/* 233 */           GCOUNTS.this.hi[this.index] = GCOUNTS.this.value[this.index];
/*     */         }
/*     */       } 
/*     */     }
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
/*     */     public int allTimeHigh() {
/* 248 */       return Math.max(current(), hi());
/*     */     }
/*     */     
/*     */     public int current() {
/* 252 */       return GCOUNTS.this.value[this.index];
/*     */     }
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
/*     */     public int hi() {
/* 268 */       return GCOUNTS.this.hi[this.index];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int index() {
/* 278 */       return this.index;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String key() {
/* 285 */       return this.key;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\values\GCOUNTS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */