/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.paths.PATH;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public abstract class Equip implements MAPPED, WearableResource {
/*     */   public final CharSequence sTarget;
/*     */   public final INFO targetInfo;
/*     */   public final RESOURCE resource;
/*     */   private final int index;
/*     */   public final double wearPerYear;
/*     */   private final double wearRateI;
/*     */   public final int equipMax;
/*     */   public final int arrivalAmount;
/*     */   public final int targetDefault;
/*     */   public final String eKey;
/*     */   protected final STAT stat;
/*     */   private final INT_O.INT_OE<Induvidual> counter;
/*  58 */   private boolean[] available = new boolean[RACES.all().size()];
/*     */   public final BValue bvalue;
/*     */   
/*     */   Equip(String coll, String key, PATH path, LISTE<Equip> all, StatsInit init) {
/*  62 */     this(coll, key, path, all, init, (Json)null);
/*     */   }
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
/*     */ 
/*     */   
/*     */   public void setAllowed(Race race, boolean allowed) {
/*  98 */     this.available[race.index] = allowed;
/*     */   }
/*     */   
/*     */   public boolean allowed(Race race) {
/* 102 */     return this.available[race.index];
/*     */   }
/*     */   
/*     */   final void push(BoostSpecs boosters, Json data) {
/* 106 */     boosters.read(data, this.bvalue);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Induvidual t, int i) {
/* 111 */     int old = this.stat.indu().get(t);
/* 112 */     if (i != old) {
/* 113 */       this.stat.indu().set(t, CLAMP.i(i, 0, max(t)));
/* 114 */       if (t.player() && t.added()) {
/* 115 */         FACTIONS.player().res().inc(this.resource, FResources.RTYPE.EQUIPPED, old - this.stat.indu().get(t));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void inc(Induvidual t, int am) {
/* 122 */     set(t, stat().indu().get(t) + am);
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(Induvidual i) {
/* 127 */     return this.stat.indu().get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 132 */     return this.index;
/*     */   }
/*     */   
/*     */   void update16(Humanoid h, int updateI, int updateR, boolean day) {
/* 136 */     if (RND.rFloat() < this.wearRateI) {
/* 137 */       Induvidual i = h.indu();
/* 138 */       int am = this.stat.indu().get(i) - (this.counter.get(i) >> 4);
/* 139 */       if (am > 0) {
/* 140 */         this.counter.inc(i, am);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int needed(Induvidual i) {
/* 147 */     int am = target(i) - get(i) + (this.counter.get(i) >> 4);
/* 148 */     if (am < 0) {
/* 149 */       wearOut(i);
/* 150 */       am = target(i) - get(i);
/* 151 */       if (am < 0) {
/* 152 */         int c = this.counter.get(i) & 0xF;
/* 153 */         if (RND.rInt(16) < c)
/* 154 */           this.stat.indu().inc(i, -1); 
/* 155 */         this.counter.set(i, 0);
/* 156 */         return target(i) - get(i);
/*     */       } 
/*     */     } 
/* 159 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void wearOut(Induvidual i) {
/* 165 */     int c = this.counter.get(i);
/* 166 */     int am = c >> 4;
/* 167 */     c &= 0xF;
/* 168 */     this.counter.set(i, c);
/* 169 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 172 */     am = CLAMP.i(am, 0, this.stat.indu().get(i));
/* 173 */     this.stat.indu().inc(i, -am);
/*     */   }
/*     */   
/*     */   public STAT stat() {
/* 177 */     return this.stat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double wearRate() {
/* 183 */     return this.wearPerYear;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource(Induvidual i) {
/* 188 */     return this.resource;
/*     */   }
/*     */   
/*     */   public RESOURCE resource() {
/* 192 */     return this.resource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double wearPerYear(Induvidual i) {
/* 202 */     return this.wearPerYear;
/*     */   }
/*     */   
/*     */   protected void hoverP(GUI_BOX box) {
/* 206 */     GBox b = (GBox)box;
/* 207 */     box.title(this.resource.name);
/* 208 */     box.text(this.resource.desc);
/* 209 */     b.NL();
/* 210 */     b.textL(StatsEquip.¤¤Wear);
/* 211 */     b.tab(8);
/* 212 */     b.add((SPRITE)GFORMAT.f0(b.text(), -this.wearPerYear * 16.0D / TIME.years().bitConversion((TIMECYCLE)TIME.days())));
/* 213 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 218 */     hoverP(box);
/* 219 */     GBox b = (GBox)box;
/* 220 */     b.sep();
/* 221 */     this.stat.boosters.hover((GUI_BOX)b, 1.0D, -1);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, Div div) {
/* 225 */     hoverP(box);
/* 226 */     GBox b = (GBox)box;
/* 227 */     b.textLL(Dic.¤¤Equipped);
/* 228 */     b.tab(7);
/* 229 */     b.add((SPRITE)GFORMAT.fofkInv(b.text(), this.stat.div().getD(div) * this.equipMax, this.equipMax));
/*     */     
/* 231 */     b.sep();
/*     */     
/* 233 */     this.stat.boosters.hover((GUI_BOX)b, (BOOSTABLE_O)div);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, HCLASS cl, Race r) {
/* 237 */     hoverP(box);
/* 238 */     GBox b = (GBox)box;
/* 239 */     b.textLL(Dic.¤¤Equipped);
/* 240 */     b.tab(7);
/* 241 */     b.add((SPRITE)GFORMAT.fofkInv(b.text(), this.stat.data(cl).getD(r) * this.equipMax, this.equipMax));
/*     */     
/* 243 */     b.sep();
/*     */     
/* 245 */     this.stat.boosters.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(r, cl));
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, Induvidual h) {
/* 249 */     hoverP(box);
/* 250 */     GBox b = (GBox)box;
/*     */     
/* 252 */     b.textLL(Dic.¤¤Equipped);
/* 253 */     b.tab(7);
/* 254 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), this.stat.indu().get(h), this.equipMax));
/*     */     
/* 256 */     b.sep();
/* 257 */     this.stat.boosters.hover((GUI_BOX)b, (BOOSTABLE_O)h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String eKey() {
/* 263 */     return this.eKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 268 */     return this.eKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 273 */     double rate = 0.25D;
/* 274 */     int ticksPerDay = 16;
/* 275 */     int daysPerYear = 16;
/* 276 */     int counterAm = 16;
/* 277 */     double chancePerTick = counterAm * rate / (ticksPerDay * daysPerYear);
/*     */     
/* 279 */     int start = 0;
/*     */     
/* 281 */     int iters = 10;
/*     */     
/* 283 */     for (int i = 0; i < ticksPerDay * 16 * iters; i++) {
/*     */       
/* 285 */       if (RND.rFloat() <= chancePerTick) {
/* 286 */         start++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 291 */     LOG.ln(Double.valueOf(start / (iters * counterAm)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Equip(String coll, String key, PATH path, LISTE<Equip> all, StatsInit init, Json text) {
/* 297 */     this.bvalue = new BValue()
/*     */       {
/*     */         public double vGet(Player f)
/*     */         {
/* 301 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/* 306 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Region reg) {
/* 311 */           return vGet(reg.faction());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE t) {
/* 318 */           return Equip.this.bValue(Equip.this.stat.data(t.cl).getD(t.race));
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Div div) {
/* 323 */           return Equip.this.bValue(Equip.this.stat.div().getD(div));
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu) {
/* 328 */           return Equip.this.bValue(Equip.this.stat.indu().getD(indu));
/*     */         }
/*     */       };
/*     */     Json data = new Json(path.gets(key));
/*     */     key = (coll + "_" + coll).replace("__", "_");
/*     */     this.eKey = key;
/*     */     this.index = all.add(this);
/*     */     this.resource = (RESOURCE)RESOURCES.map().read(data);
/*     */     this.wearPerYear = data.d("WEAR_RATE", 0.0D, 100.0D);
/*     */     this.equipMax = data.i("MAX_AMOUNT", 1, 15);
/*     */     this.arrivalAmount = data.i("ARRIVAL_AMOUNT", 0, this.equipMax);
/*     */     this.targetDefault = data.i("DEFAULT_TARGET");
/*     */     StatStanding.StandingDef standing = new StatStanding.StandingDef(data);
/*     */     this.wearRateI = this.wearPerYear / 16.0D;
/*     */     this.sTarget = (CharSequence)(new Str(StatsEquip.¤¤Target)).insert(0, this.resource.name).trim();
/*     */     this.targetInfo = new INFO((CharSequence)(new Str(StatsEquip.¤¤Level)).insert(0, this.resource.name).trim(), StatsEquip.¤¤Level_desc);
/*     */     this.stat = (STAT)new STATData(key, init, (DataO.DataAbs)new DataO.DataNibble(init.count, coll + "_" + coll + "_MAX", this.equipMax), (text == null) ? new StatInfo(this.resource.name, this.resource.names, this.resource.desc) : new StatInfo(text));
/*     */     this.stat.standing = new StatStanding(this.stat, 0.0D, standing);
/*     */     this.stat.info().setInt();
/*     */     this.counter = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, coll + "_" + coll + "_COUNTER");
/*     */     push(this.stat.boosters, data);
/*     */     (this.stat.info()).icon = (SPRITE)this.resource.icon();
/*     */     Arrays.fill(this.available, true);
/*     */   }
/*     */   
/*     */   public abstract double bValue(double paramDouble);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\Equip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */