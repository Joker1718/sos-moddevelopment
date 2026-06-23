/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.WGROUP;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.orchard.ROOM_ORCHARD;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class RoomEmployments {
/*  38 */   private static CharSequence ¤¤allFarms = "Farm Employees";
/*  39 */   private static CharSequence ¤¤allRefiner = "Refiner Employees";
/*  40 */   private static CharSequence ¤¤allMine = "Mine Employees";
/*  41 */   private static CharSequence ¤¤pasture = "Pasture Employees";
/*  42 */   private static CharSequence ¤¤workshop = "Workshop Employees";
/*  43 */   private static CharSequence ¤¤orchard = "Orchard Employees";
/*  44 */   private static CharSequence ¤¤fishery = "Fishery Employees"; private final LIST<RoomEmployment> all; private final LIST<RoomEmploymentSimple> allS;
/*     */   static {
/*  46 */     D.ts(RoomEmployments.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  51 */   private int needed = 0;
/*  52 */   private int current = 0;
/*  53 */   private int target = 0;
/*  54 */   private int upI = 0;
/*  55 */   private final RaceGroup[] groups = new RaceGroup[WGROUP.all().size()];
/*     */   private int[] searchIS;
/*  57 */   final HistoryInt history = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*     */ 
/*     */ 
/*     */   
/*     */   final Employer employer;
/*     */ 
/*     */ 
/*     */   
/*     */   public final RoomEquips equip;
/*     */ 
/*     */ 
/*     */   
/*     */   public final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   public INT NEEDED;
/*     */ 
/*     */ 
/*     */   
/*     */   public INT_O<WGROUP> CURRENT;
/*     */ 
/*     */ 
/*     */   
/*     */   public INT_O<WGROUP> TARGET;
/*     */ 
/*     */ 
/*     */   
/*     */   private static void pushReq(String key, CharSequence name, SPRITE icon, final LIST<? extends RoomBlueprintIns<?>> li) {
/*  86 */     GVALUES.FACTION.push("EMPLOYED_" + key, name, icon, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  90 */             int a = 0;
/*  91 */             for (RoomBlueprintIns<?> b : (Iterable<RoomBlueprintIns<?>>)li) {
/*  92 */               a += b.employment().employed();
/*     */             }
/*  94 */             return a;
/*     */           }
/*     */         }, 
/*  97 */         false);
/*     */   }
/*     */ 
/*     */   
/*     */   void changeCurrent(int current, WGROUP g) {
/* 102 */     this.current += current;
/* 103 */     this.groups[g.index()].change(current);
/*     */   }
/*     */   
/*     */   void changeNeeded(RoomBlueprintIns<?> b, int total) {
/* 107 */     this.needed += total;
/*     */   }
/*     */ 
/*     */   
/*     */   void changeTarget(int current, WGROUP g) {
/* 112 */     this.target += current;
/* 113 */     (this.groups[g.index()]).target += current;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 118 */     this.groups[this.upI].update();
/* 119 */     this.upI++;
/* 120 */     if (this.upI == this.groups.length) {
/* 121 */       this.upI = 0;
/*     */     }
/*     */ 
/*     */     
/* 125 */     this.employer.update();
/*     */   }
/*     */   
/*     */   public void setTargets() {
/* 129 */     this.employer.updateAll();
/*     */   }
/*     */   
/* 132 */   public RoomEmployments(ROOMS rooms) { this.saver = new SAVABLE()
/*     */       {
/*     */         
/*     */         public void save(FilePutter file)
/*     */         {
/* 137 */           RoomEmployments.this.history.save(file);
/* 138 */           RoomEmployments.this.equip.saver.save(file);
/*     */           
/* 140 */           file.i(RoomEmployments.this.allS.size());
/* 141 */           for (RoomEmploymentSimple s : RoomEmployments.this.allS) {
/* 142 */             file.chars((s.blueprint()).key);
/* 143 */             int pos = file.getPosition();
/* 144 */             file.i(0);
/* 145 */             s.save(file);
/* 146 */             int le = file.getPosition() - pos - 4;
/* 147 */             file.setAtPosition(pos, le);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 155 */           clear();
/*     */           
/* 157 */           RoomEmployments.this.history.load(file);
/* 158 */           RoomEmployments.this.equip.saver.load(file);
/*     */           
/* 160 */           int am = file.i();
/* 161 */           for (int i = 0; i < am; i++) {
/*     */             
/* 163 */             String k = file.chars();
/*     */             
/* 165 */             RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).collection.tryGet(k);
/* 166 */             int skip = file.i();
/* 167 */             if (p == null || p.employment() == null) {
/*     */               
/* 169 */               file.setPosition(file.getPosition() + skip);
/*     */             } else {
/* 171 */               p.employment().load(file);
/*     */             } 
/*     */           } 
/*     */           
/* 175 */           for (RoomEmploymentSimple ss : RoomEmployments.this.allS) {
/*     */             
/* 177 */             if (ss instanceof RoomEmployment) {
/* 178 */               RoomEmployment s = (RoomEmployment)ss;
/* 179 */               for (WGROUP g : WGROUP.all()) {
/* 180 */                 RoomEmployments.this.changeCurrent(s.employed(g), g);
/* 181 */                 RoomEmployments.this.changeTarget(s.target.group(g), g);
/*     */               } 
/*     */             } 
/* 184 */             RoomEmployments.this.changeNeeded(ss.blueprint(), ss.neededWorkers());
/* 185 */             RoomBlueprintIns<?> blue = ss.blueprint();
/* 186 */             if (blue.employment() != null) {
/* 187 */               for (int j = 0; j < blue.instancesSize(); j++) {
/* 188 */                 RoomInstance ins = blue.getInstance(j);
/* 189 */                 blue.employment().loadadd(ins.employees());
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void clear() {
/* 200 */           RoomEmployments.this.needed = 0;
/* 201 */           RoomEmployments.this.current = 0;
/* 202 */           RoomEmployments.this.target = 0; byte b; int i; RoomEmployments.RaceGroup[] arrayOfRaceGroup;
/* 203 */           for (i = (arrayOfRaceGroup = RoomEmployments.this.groups).length, b = 0; b < i; ) { RoomEmployments.RaceGroup g = arrayOfRaceGroup[b];
/* 204 */             g.clear(); b++; }
/* 205 */            Arrays.fill(RoomEmployments.this.searchIS, 0);
/* 206 */           for (RoomEmployment e : RoomEmployments.this.all)
/* 207 */             e.setPrioOnSkill(); 
/* 208 */           RoomEmployments.this.history.clear();
/* 209 */           for (RoomEmploymentSimple s : RoomEmployments.this.allS)
/* 210 */             s.clear(); 
/* 211 */           RoomEmployments.this.equip.saver.clear();
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
/* 245 */     this.NEEDED = new INT()
/*     */       {
/*     */         public int get()
/*     */         {
/* 249 */           return RoomEmployments.this.needed;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 254 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 259 */           return RoomEmployments.this.needed;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 264 */     this.CURRENT = new INT_O<WGROUP>()
/*     */       {
/*     */         public int get(WGROUP t)
/*     */         {
/* 268 */           if (t == null)
/* 269 */             return RoomEmployments.this.current; 
/* 270 */           return (RoomEmployments.this.groups[t.index()]).current;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(WGROUP t) {
/* 275 */           return 0;
/*     */         }
/*     */         
/*     */         public int max(WGROUP t) {
/* 279 */           return Integer.MAX_VALUE;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 284 */     this.TARGET = new INT_O<WGROUP>()
/*     */       {
/*     */         public int get(WGROUP t)
/*     */         {
/* 288 */           if (t == null)
/* 289 */             return RoomEmployments.this.target; 
/* 290 */           return (RoomEmployments.this.groups[t.index()]).target;
/*     */         }
/*     */         
/*     */         public int min(WGROUP t) {
/* 294 */           return 0;
/*     */         }
/*     */         
/*     */         public int max(WGROUP t) {
/* 298 */           return Integer.MAX_VALUE;
/*     */         } }; this.all = (LIST<RoomEmployment>)new ArrayList((Iterable)RoomEmployment.WORK); this.allS = (LIST<RoomEmploymentSimple>)new ArrayList((Iterable)RoomEmploymentSimple.WORK_ALL); RoomEmployment.WORK.clear(); this.searchIS = Alloc.ii(this.all.size()); for (WGROUP g : WGROUP.all())
/*     */       this.groups[g.index()] = new RaceGroup(g, this);  this.equip = new RoomEquips(rooms, this); this.employer = new Employer(this.all); pushReq("FARM", ¤¤allFarms, (SPRITE)(UI.icons()).l.farm, rooms.FARMS); pushReq("REFINER", ¤¤allRefiner, (SPRITE)(UI.icons()).l.refiner, rooms.REFINERS); pushReq("MINE", ¤¤allMine, (SPRITE)(UI.icons()).l.mine, rooms.MINES); pushReq("PASTURE", ¤¤pasture, (SPRITE)(UI.icons()).l.pasture, rooms.PASTURES); pushReq("WORKSHOP", ¤¤workshop, (SPRITE)(UI.icons()).l.workshop, rooms.WORKSHOPS);
/*     */     pushReq("ORCHARD", ¤¤orchard, (SPRITE)((ROOM_ORCHARD)rooms.ORCHARDS.get(0)).iconBig(), rooms.ORCHARDS);
/*     */     pushReq("FISHERY", ¤¤fishery, (SPRITE)(UI.icons()).l.fish, rooms.FISHERIES); }
/*     */   public HISTORY_INT hEmployed() { return (HISTORY_INT)this.history; }
/*     */   public void setWork(Humanoid h) { Induvidual i = h.indu();
/*     */     if (!i.hType().isWorks())
/*     */       throw new RuntimeException(); 
/*     */     this.groups[WGROUP.get(i).index()].setWork(h, this.searchIS); } public boolean hasWork(Humanoid h) { Induvidual i = h.indu();
/*     */     if (!i.hType().isWorks())
/*     */       return false; 
/*     */     return this.groups[WGROUP.get(i).index()].hasWork(h); } public LIST<RoomEmployment> ALL() { return this.all; } public LIST<RoomEmploymentSimple> ALLS() { return this.allS; } private static class RaceGroup implements SAVABLE
/*     */   {
/* 312 */     int target; int current; public RaceGroup(WGROUP group, RoomEmployments es) { this.es = es;
/* 313 */       this.possibles = new IntegerStack(es.all.size());
/* 314 */       this.group = group; }
/*     */     
/*     */     final IntegerStack possibles; private final RoomEmployments es; private WGROUP group;
/*     */     void change(int current) {
/* 318 */       this.current += current;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean setWork(Humanoid i, int[] searchI) {
/* 325 */       RoomInstance old = (RoomInstance)(STATS.WORK()).EMPLOYED.get(i);
/*     */       
/* 327 */       if (old != null && old.blueprintI().employment() instanceof RoomEmployment) {
/* 328 */         RoomEmployment ee = (RoomEmployment)old.blueprintI().employment();
/* 329 */         if (ee.employed(this.group) > ee.target.group(this.group)) {
/* 330 */           (STATS.WORK()).EMPLOYED.set(i, null);
/*     */         }
/* 332 */         else if (old.employees().isOverstaffed()) {
/* 333 */           (STATS.WORK()).EMPLOYED.set(i, null);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 339 */       if ((STATS.WORK()).EMPLOYED.get(i) != null) {
/* 340 */         return true;
/*     */       }
/* 342 */       if (this.current >= this.target) {
/* 343 */         return false;
/*     */       }
/*     */       
/* 346 */       while (!this.possibles.isEmpty()) {
/* 347 */         RoomEmployment e = (RoomEmployment)this.es.all.get(this.possibles.pop());
/* 348 */         if (e.employed() < e.neededWorkers() && e.employed(this.group) < e.target.group(this.group)) {
/* 349 */           this.possibles.push(e.index());
/* 350 */           return setWork(i, e, searchI);
/*     */         } 
/*     */       } 
/*     */       
/* 354 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean hasWork(Humanoid i) {
/* 359 */       return (this.current < this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean setWork(Humanoid i, RoomEmployment e, int[] searchI) {
/* 364 */       int am = e.blueprint().instancesSize();
/*     */       
/* 366 */       for (int k = 0; k < am; k++) {
/* 367 */         if (searchI[e.index()] >= am)
/* 368 */           searchI[e.index()] = 0; 
/* 369 */         RoomInstance ins = e.blueprint().getInstance(searchI[e.index()]);
/* 370 */         if (ins.active() && ins.employees().employed() < ins.employees().target()) {
/* 371 */           (STATS.WORK()).EMPLOYED.set(i, ins);
/* 372 */           return true;
/*     */         } 
/* 374 */         searchI[e.index()] = searchI[e.index()] + 1;
/*     */       } 
/*     */ 
/*     */       
/* 378 */       GAME.Notify("oh no!" + String.valueOf((e.blueprint()).info.name) + " " + String.valueOf((i.race()).info.name) + " " + e.target.group(this.group) + " " + e.employed(this.group) + " " + e.employed() + " " + e.neededWorkers());
/* 379 */       for (int ii = 0; ii < am; ii++) {
/* 380 */         RoomInstance ins = e.blueprint().getInstance(ii);
/* 381 */         LOG.ln("" + ins.employees().employed() + "  " + ins.employees().employed());
/*     */       } 
/*     */       
/* 384 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void update() {
/* 389 */       this.possibles.clear();
/* 390 */       for (RoomEmployment p : (SETT.ROOMS()).employment.all) {
/* 391 */         if (p.employed() < p.neededWorkers() && p.employed(this.group) < p.target.group(this.group)) {
/* 392 */           this.possibles.push(p.index());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 399 */       file.i(this.current);
/* 400 */       file.i(this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 405 */       this.current = file.i();
/* 406 */       this.target = file.i();
/* 407 */       this.possibles.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 412 */       this.current = 0;
/* 413 */       this.target = 0;
/* 414 */       this.possibles.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployments.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */