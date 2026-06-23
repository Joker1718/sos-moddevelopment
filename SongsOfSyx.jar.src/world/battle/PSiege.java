/*     */ package world.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListInt;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.message.MessageText;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PSiege
/*     */   implements SAVABLE
/*     */ {
/*  28 */   private final ArrayListInt besieged = new ArrayListInt(1023);
/*  29 */   private final Bitmap1D besigedMap = new Bitmap1D(1023, false);
/*  30 */   private final Bitmap1D first = new Bitmap1D(1023, false);
/*  31 */   private final double[] besigeTime = new double[1023];
/*  32 */   private final ArrayListInt active = new ArrayListInt(1023);
/*  33 */   private final Bitmap1D map = new Bitmap1D(1023, false);
/*     */   private double dd;
/*  35 */   private static double dTime = 128.0D;
/*  36 */   private static double dTimeI = 1023.0D / dTime;
/*     */   
/*     */   private final Util util;
/*     */   private final Side.Conflict conflict;
/*     */   private final Resolver resolver;
/*  41 */   private int playerRegAttackRegion = -1;
/*     */ 
/*     */   
/*  44 */   private static CharSequence ¤¤name = "Besieged";
/*  45 */   private static CharSequence ¤¤desc = "The city of {0} have been besieged by our enemies!";
/*     */   
/*     */   static {
/*  48 */     D.ts(PSiege.class);
/*     */   }
/*     */   
/*     */   public PSiege(Util util, Side.Conflict conflict, Resolver resolver) {
/*  52 */     this.util = util;
/*  53 */     this.conflict = conflict;
/*  54 */     this.resolver = resolver;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  59 */     this.besieged.save(file);
/*  60 */     this.besigedMap.save(file);
/*  61 */     file.ds(this.besigeTime);
/*  62 */     file.d(this.dd);
/*  63 */     this.active.save(file);
/*  64 */     this.map.save(file);
/*  65 */     this.first.save(file);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  69 */     this.besieged.load(file);
/*  70 */     this.besigedMap.load(file);
/*  71 */     file.ds(this.besigeTime);
/*  72 */     this.dd = file.d();
/*  73 */     this.active.load(file);
/*  74 */     this.map.load(file);
/*  75 */     this.first.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  80 */     this.besieged.clear();
/*  81 */     this.besigedMap.clear();
/*  82 */     Arrays.fill(this.besigeTime, 0.0D);
/*  83 */     this.dd = 0.0D;
/*  84 */     this.active.clear();
/*  85 */     this.map.clear();
/*  86 */     this.first.clear();
/*     */   }
/*     */   
/*     */   public void register(WArmy a) {
/*  90 */     Region reg = a.besieging();
/*  91 */     if (reg != null && !this.map.get(reg.index())) {
/*  92 */       this.map.set(reg.index(), true);
/*  93 */       this.first.set(reg.index(), true);
/*  94 */       this.active.add(reg.index());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void playerBesige(Region reg) {
/*  99 */     this.playerRegAttackRegion = reg.index();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 104 */     for (int i = 0; i < this.besieged.size(); i++) {
/* 105 */       int ri = this.besieged.get(i);
/* 106 */       Region reg = WORLD.REGIONS().getByIndex(ri);
/* 107 */       if (this.util.getBesieger(reg) == null) {
/* 108 */         this.besieged.remove(i);
/* 109 */         this.besigedMap.set(ri, false);
/* 110 */         i--;
/*     */       } 
/*     */     } 
/*     */     
/* 114 */     int current = (int)this.dd;
/* 115 */     this.dd += ds * dTimeI;
/* 116 */     int next = (int)this.dd;
/*     */     
/* 118 */     while (current < next) {
/*     */       
/* 120 */       int ri = current % 1023;
/* 121 */       current++;
/* 122 */       Region reg = WORLD.REGIONS().getByIndex(ri);
/* 123 */       if (!reg.active())
/*     */         continue; 
/* 125 */       WArmy a = this.util.getBesieger(reg);
/* 126 */       if (a != null) {
/* 127 */         this.besigeTime[ri] = this.besigeTime[ri] + dTime;
/*     */       } else {
/* 129 */         this.besigeTime[ri] = this.besigeTime[ri] - dTime * 4.0D;
/*     */       } 
/* 131 */       this.besigeTime[ri] = CLAMP.d(this.besigeTime[ri], 0.0D, 8.988465674311579E307D);
/*     */     } 
/*     */ 
/*     */     
/* 135 */     while (this.dd >= 1023.0D) {
/* 136 */       this.dd -= 1023.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public double besigedTime(Region reg) {
/* 141 */     return this.besigeTime[reg.index()];
/*     */   }
/*     */   
/*     */   public boolean besiged(Region reg) {
/* 145 */     return this.besigedMap.get(reg.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public void besige(WArmy a, Region reg) {
/* 150 */     if (!this.besigedMap.get(reg.index())) {
/* 151 */       this.besigedMap.set(reg.index(), true);
/* 152 */       this.besieged.add(reg.index());
/* 153 */       if (reg.faction() == FACTIONS.player() && !reg.capitol()) {
/* 154 */         double regPow = RD.MILITARY().defensePower(reg);
/* 155 */         double aPow = AD.power().get(a);
/*     */         
/* 157 */         Util.Pair allies = this.util.fill(a.faction(), reg.faction(), reg.cx(), reg.cy());
/* 158 */         for (WArmy a2 : allies.a) {
/* 159 */           if (a2 != a) {
/* 160 */             aPow += AD.power().get(a2);
/*     */           }
/*     */         } 
/* 163 */         if (regPow > aPow) {
/* 164 */           (new MessageText(¤¤name, (CharSequence)Str.TMP.clear().add(¤¤desc).insert(0, (CharSequence)reg.info.name()))).send();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 170 */     if (a.faction() == FACTIONS.player()) {
/* 171 */       this.playerRegAttackRegion = reg.index();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean poll() {
/* 177 */     if (this.playerRegAttackRegion >= 0) {
/* 178 */       Region reg = WORLD.REGIONS().getByIndex(this.playerRegAttackRegion);
/* 179 */       this.playerRegAttackRegion = -1;
/* 180 */       WArmy a = this.util.getBesieger(reg);
/*     */       
/* 182 */       if (a != null && a.faction() == FACTIONS.player() && 
/* 183 */         create(a, reg, true)) {
/* 184 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 188 */     int death = 1000;
/*     */     
/* 190 */     while (!this.active.isEmpty()) {
/* 191 */       int ai = this.active.get(this.active.size() - 1);
/* 192 */       Region reg = (Region)WORLD.REGIONS().all().get(ai);
/* 193 */       boolean f = this.first.get(reg.index());
/* 194 */       this.first.set(reg.index(), false);
/* 195 */       if (create(reg, f)) {
/* 196 */         return true;
/*     */       }
/* 198 */       this.map.set(this.active.get(this.active.size() - 1), false);
/* 199 */       this.active.remove(this.active.size() - 1);
/*     */       
/* 201 */       if (death-- < 0) {
/* 202 */         LOG.err("NOHA!");
/*     */         break;
/*     */       } 
/*     */     } 
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean create(Region reg, boolean first) {
/* 211 */     if (reg == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     WArmy a = this.util.getBesieger(reg);
/* 215 */     if (a != null && a.faction() != FACTIONS.player())
/* 216 */       return create(a, reg, first); 
/* 217 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean create(WArmy a, Region reg, boolean first) {
/* 225 */     if (!Util.enemies(reg.faction(), a.faction())) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (a.besieging() != reg) {
/* 229 */       return false;
/*     */     }
/* 231 */     double regPow = RD.MILITARY().defensePower(reg);
/* 232 */     double aPow = AD.power().get(a);
/*     */     
/* 234 */     Util.Pair allies = this.util.fill(a.faction(), reg.faction(), reg.cx(), reg.cy());
/* 235 */     for (WArmy a2 : allies.a) {
/* 236 */       if (a2 != a) {
/* 237 */         aPow += AD.power().get(a2);
/*     */       }
/*     */     } 
/* 240 */     for (WArmy a2 : allies.b) {
/* 241 */       regPow += AD.power().get(a2);
/*     */     }
/*     */     
/* 244 */     if (a.faction() != FACTIONS.player() && regPow > aPow) {
/* 245 */       return false;
/*     */     }
/*     */     
/* 248 */     this.conflict.clear();
/* 249 */     this.conflict.A.add(a);
/*     */     
/* 251 */     for (WArmy a2 : allies.a) {
/* 252 */       if (a != a2)
/* 253 */         this.conflict.A.add(a2); 
/*     */     } 
/* 255 */     this.conflict.B.add(reg);
/* 256 */     for (WArmy a2 : allies.b) {
/* 257 */       this.conflict.B.add(a2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 262 */     return this.resolver.besige(this.conflict.A, this.conflict.B, first);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\PSiege.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */