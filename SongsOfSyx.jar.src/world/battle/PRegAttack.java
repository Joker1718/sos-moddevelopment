/*     */ package world.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListInt;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PRegAttack
/*     */   implements SAVABLE
/*     */ {
/*  24 */   private final ArrayListInt active = new ArrayListInt(1023);
/*  25 */   private final Bitmap1D map = new Bitmap1D(1023, false);
/*  26 */   private final ArrayListResize<WArmy> armies = new ArrayListResize(120);
/*     */   private final Side.Conflict conflict;
/*     */   private final Resolver init;
/*     */   private final Util util;
/*  30 */   private int playerRegAttackRegion = -1;
/*  31 */   private int playerRegAttackArmy = -1;
/*     */ 
/*     */   
/*     */   public PRegAttack(Side.Conflict conflict, Resolver init, Util util) {
/*  35 */     this.conflict = conflict;
/*  36 */     this.util = util;
/*  37 */     this.init = init;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  42 */     this.active.save(file);
/*  43 */     this.map.save(file);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  47 */     this.active.load(file);
/*  48 */     this.map.load(file);
/*     */   }
/*     */   
/*     */   public void clear() {
/*  52 */     this.active.clear();
/*  53 */     this.map.clear();
/*     */   }
/*     */   
/*     */   public void register(WArmy a) {
/*  57 */     if (a.region() != null && !this.map.get(a.region().index())) {
/*  58 */       this.map.set(a.region().index(), true);
/*  59 */       this.active.add(a.region().index());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void regAttack(Region reg, WArmy a) {
/*  64 */     this.playerRegAttackArmy = a.armyIndex();
/*  65 */     this.playerRegAttackRegion = reg.index();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean poll() {
/*  71 */     if (this.playerRegAttackArmy >= 0) {
/*  72 */       Region reg = WORLD.REGIONS().getByIndex(this.playerRegAttackRegion);
/*  73 */       WArmy a = (WORLD.ENTITIES()).armies.get(this.playerRegAttackArmy);
/*  74 */       this.playerRegAttackArmy = -1;
/*  75 */       if (reg.faction() == FACTIONS.player() && 
/*  76 */         create(reg, a)) {
/*  77 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  81 */     int death = 1000;
/*     */     
/*  83 */     while (!this.active.isEmpty()) {
/*  84 */       int ai = this.active.get(this.active.size() - 1);
/*  85 */       Region reg = (Region)WORLD.REGIONS().all().get(ai);
/*  86 */       if (create(reg)) {
/*  87 */         return true;
/*     */       }
/*  89 */       this.map.set(this.active.get(this.active.size() - 1), false);
/*  90 */       this.active.remove(this.active.size() - 1);
/*     */       
/*  92 */       if (death-- < 0) {
/*  93 */         LOG.err("NOHA!");
/*     */         break;
/*     */       } 
/*     */     } 
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean create(Region reg) {
/* 102 */     if (reg == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     if ((RD.MILITARY()).garrison.get(reg) <= 0) {
/* 106 */       return false;
/*     */     }
/* 108 */     if (reg.faction() == FACTIONS.player()) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (reg.besieged()) {
/* 113 */       WArmy a = this.util.getBesieger(reg);
/* 114 */       if (a != null) {
/* 115 */         return create(reg, a);
/*     */       }
/*     */     } 
/*     */     
/* 119 */     this.armies.clearSoft();
/* 120 */     this.armies.add((Iterable)(WORLD.ENTITIES()).armies.fill(reg));
/*     */     
/* 122 */     for (WArmy a : this.armies) {
/* 123 */       if (a.region() == reg && create(reg, a)) {
/* 124 */         return true;
/*     */       }
/*     */     } 
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean create(Region reg, WArmy a) {
/* 135 */     if (Util.valid(a) == null) {
/* 136 */       return false;
/*     */     }
/* 138 */     if (reg == null) {
/* 139 */       return false;
/*     */     }
/* 141 */     if ((RD.MILITARY()).garrison.get(reg) <= 0) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (!Util.enemies(reg.faction(), a.faction())) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (reg.besieged() && 
/* 148 */       a.besieging() != reg) {
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     double regPow = (RD.MILITARY()).power.getD(reg);
/* 153 */     double aPow = AD.power().get(a);
/*     */ 
/*     */     
/* 156 */     Util.Pair allies = this.util.fill(reg.faction(), a.faction(), a.ctx(), a.cty());
/* 157 */     boolean p = (reg.faction() == FACTIONS.player());
/* 158 */     for (WArmy a2 : allies.a) {
/* 159 */       if (p || a2.faction() == FACTIONS.player()) {
/* 160 */         aPow += AD.power().get(a2);
/*     */       }
/*     */     } 
/* 163 */     for (WArmy a2 : allies.b) {
/* 164 */       if (a2 != a) {
/* 165 */         aPow += AD.power().get(a2);
/*     */       }
/*     */     } 
/* 168 */     if (!p && regPow < aPow) {
/* 169 */       return false;
/*     */     }
/* 171 */     this.conflict.clear();
/* 172 */     this.conflict.A.add(reg);
/* 173 */     for (WArmy a2 : allies.a) {
/* 174 */       this.conflict.A.add(a2);
/*     */     }
/* 176 */     this.conflict.B.add(a);
/* 177 */     for (WArmy a2 : allies.b) {
/* 178 */       if (a != a2) {
/* 179 */         this.conflict.B.add(a2);
/*     */       }
/*     */     } 
/* 182 */     this.init.init(this.conflict.A, this.conflict.B);
/* 183 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\PRegAttack.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */