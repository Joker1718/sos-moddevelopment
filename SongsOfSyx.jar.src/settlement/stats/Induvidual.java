/*     */ package settlement.stats;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Tuple;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ public final class Induvidual
/*     */   extends Humanoid.HumanoidResource implements Serializable, BOOSTABLE_O {
/*     */   private static final long serialVersionUID = 1L;
/*  38 */   long[] data = new long[STATS.count().longCount()];
/*     */   
/*     */   private byte race;
/*     */   
/*     */   private byte type;
/*     */   private boolean added = false;
/*     */   
/*     */   public Induvidual(HTYPE type, Race race) {
/*  46 */     this.race = (byte)race.index;
/*  47 */     this.type = (byte)type.index();
/*     */     
/*  49 */     if (type == HTYPES.SLAVE()) {
/*  50 */       (GAME.count()).ENSLAVED.inc(1);
/*  51 */     } else if (type == HTYPES.PRISONER()) {
/*  52 */       (STATS.LAW()).prisonerType.set(this, CRIMES.WAR());
/*  53 */     }  STATS.get().construct(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/*  58 */     in.defaultReadObject();
/*     */     
/*  60 */     long[] oldData = this.data;
/*  61 */     this.data = new long[STATS.count().longCount()];
/*  62 */     STATS.count().loader().wash(this, oldData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Induvidual(FileGetter p) throws IOException {
/*  69 */     STATS.count().loader().load(this, p);
/*     */     
/*  71 */     this.race = (byte)((Race)RACES.map().loader().loadB(p, (MAPPED)FACTIONS.player().race())).index;
/*  72 */     this.type = (byte)((HTYPE)HTYPES.MAP().loader().loadB(p, (MAPPED)HTYPES.SUBJECT())).index();
/*  73 */     this.added = p.bool();
/*  74 */     if (this.added) {
/*  75 */       STATS.get().add(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter p) {
/*  83 */     STATS.count().saver().save(this, p);
/*  84 */     RACES.map().saver().save((MAPPED)race(), p);
/*  85 */     HTYPES.MAP().saver().save((MAPPED)hType(), p);
/*     */ 
/*     */     
/*  88 */     p.bool(this.added);
/*     */   }
/*     */   
/*     */   public void copyFrom(Induvidual other) {
/*  92 */     (STATS.get()).copy.copy(this, other);
/*     */   }
/*     */   
/*     */   public void copyFromHard(Induvidual other) {
/*  96 */     if (this.added) {
/*  97 */       throw new RuntimeException();
/*     */     }
/*  99 */     (STATS.POP()).COUNT.reg(other, CAUSE_LEAVES.OTHER());
/*     */ 
/*     */     
/* 102 */     STATS.get().remove(this);
/* 103 */     this.race = other.race;
/* 104 */     this.type = other.type;
/* 105 */     STATS.get().add(this);
/*     */     
/* 107 */     (STATS.get()).copy.copy(this, other);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void add(Humanoid h, CAUSE_ARRIVE a) {
/* 112 */     if (this.added)
/*     */       return; 
/* 114 */     this.added = true;
/* 115 */     for (Tuple<STAT, Double> t : (Iterable<Tuple<STAT, Double>>)race().stats().arrivalStats()) {
/* 116 */       ((STAT)t.a()).indu().setD(this, CLAMP.d(RND.rFloat0(0.2D) * ((Double)t.b()).doubleValue(), 0.0D, 1.0D));
/*     */     }
/* 118 */     STATS.get().add(this);
/*     */     
/* 120 */     (STATS.POP()).COUNT.reg(this, a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid h) {
/* 125 */     if (!this.added)
/*     */       return; 
/* 127 */     STATS.get().cancel(h);
/* 128 */     this.added = false;
/*     */   }
/*     */   
/*     */   public boolean added() {
/* 132 */     return this.added;
/*     */   }
/*     */   
/*     */   public HTYPE hType() {
/* 136 */     return (HTYPE)HTYPES.ALL().get(this.type & 0xFF);
/*     */   }
/*     */   
/*     */   public HCLASS clas() {
/* 140 */     return ((HTYPE)HTYPES.ALL().get(this.type & 0xFF)).CLASS;
/*     */   }
/*     */   
/*     */   public HCLASS_RACE popCL() {
/* 144 */     return ((HTYPE)HTYPES.ALL().get(this.type & 0xFF)).CLASS.get(race());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hTypeSet(Humanoid h, HTYPE t, CAUSE_LEAVE leave, CAUSE_ARRIVE arr) {
/* 155 */     if (t != hType()) {
/* 156 */       HTYPE old = hType();
/* 157 */       (STATS.POP()).COUNT.reg(h.indu(), leave);
/* 158 */       (SETT.PATH()).finders.entity.report((ENTITY)h, -1);
/* 159 */       (STATS.WORK()).EMPLOYED.set(h, null);
/* 160 */       STATS.HOME().dump(h);
/* 161 */       (STATS.HOME()).GETTER.set(h, null);
/* 162 */       (STATS.BATTLE()).ROUTING.indu().set(this, 0);
/* 163 */       Div d = (Div)(STATS.BATTLE()).DIV.get(h);
/* 164 */       if (!(AI.modules()).battle.has(t)) {
/* 165 */         (STATS.BATTLE()).DIV.set(h, null);
/*     */       }
/* 167 */       STATS.get().remove(this);
/*     */       
/* 169 */       this.type = (byte)t.index();
/* 170 */       STATS.get().add(this);
/*     */       
/* 172 */       (SETT.PATH()).finders.entity.report((ENTITY)h, 1);
/* 173 */       if (keepDiv(old) && keepDiv(t)) {
/* 174 */         h.setDivision(d);
/*     */       }
/* 176 */       (STATS.POP()).COUNT.reg(h.indu(), arr);
/* 177 */       if (t == HTYPES.SLAVE()) {
/* 178 */         (GAME.count()).ENSLAVED.inc(1);
/* 179 */       } else if (old == HTYPES.SLAVE() && t.CLASS.player) {
/* 180 */         (GAME.count()).FREED_SLAVES.inc(1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void raceSet(Humanoid h, Race race, CAUSE_LEAVE leave, CAUSE_ARRIVE arr) {
/* 186 */     if (this.race != race.index()) {
/* 187 */       (STATS.POP()).COUNT.reg(h.indu(), leave);
/* 188 */       (SETT.PATH()).finders.entity.report((ENTITY)h, -1);
/* 189 */       (STATS.WORK()).EMPLOYED.set(h, null);
/* 190 */       STATS.HOME().dump(h);
/* 191 */       (STATS.HOME()).GETTER.set(h, null);
/* 192 */       (STATS.BATTLE()).ROUTING.indu().set(this, 0);
/* 193 */       (STATS.BATTLE()).DIV.set(h, null);
/*     */       
/* 195 */       STATS.get().remove(this);
/* 196 */       this.race = (byte)race.index();
/* 197 */       STATS.get().add(this);
/*     */       
/* 199 */       (SETT.PATH()).finders.entity.report((ENTITY)h, 1);
/* 200 */       (STATS.POP()).COUNT.reg(h.indu(), arr);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean keepDiv(HTYPE t) {
/* 205 */     return !(t != HTYPES.STUDENT() && t != HTYPES.SUBJECT() && t != HTYPES.RECRUIT());
/*     */   }
/*     */   
/*     */   public Race race() {
/* 209 */     return (Race)RACES.all().get(this.race);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean i2sDead() {
/* 214 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(Humanoid h, int updateI, boolean newDay) {
/* 219 */     STATS.update(h, updateI, newDay);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(Humanoid h, double ds) {
/* 224 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public boolean player() {
/* 228 */     return (clas()).player;
/*     */   }
/*     */   
/*     */   public boolean hostile() {
/* 232 */     return hType().isHostile();
/*     */   }
/*     */   
/*     */   public Army army() {
/* 236 */     return hType().isHostile() ? GAME.ARMIES().enemy() : GAME.ARMIES().player();
/*     */   }
/*     */   
/*     */   public Div division() {
/* 240 */     return (Div)(STATS.BATTLE()).DIV.get(this);
/*     */   }
/*     */   
/*     */   public Faction faction() {
/* 244 */     if (hType() != HTYPES.ENEMY())
/* 245 */       return (Faction)FACTIONS.player(); 
/* 246 */     return (Faction)FACTIONS.otherFaction();
/*     */   }
/*     */ 
/*     */   
/*     */   public double boostableValue(BValue v) {
/* 251 */     return v.vGet(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\Induvidual.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */