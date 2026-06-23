/*     */ package game.boosting;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
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
/*     */ public final class Battle
/*     */   extends BOOSTABLES.BoostableCollection
/*     */ {
/* 165 */   public final Boostable OFFENCE = make("OFFENCE_SKILL", 1.0D, (Icon)(UI.icons()).s.sword, 
/* 166 */       D.g("BATTLE_OFFENCE_SKILL", "Offence"), 
/* 167 */       D.g("BATTLE_OFFENCE_SKILL_D", "Increases the ability to attack an enemy."));
/*     */   
/* 169 */   public final Boostable DEFENCE = make("DEFENCE_SKILL", 1.0D, (Icon)(UI.icons()).s.shield, 
/* 170 */       D.g("BATTLE_DEFENCE_SKILL", "Defence"), 
/* 171 */       D.g("BATTLE_DEFENCE_SKILL_D", "Increases the ability to avoid attacks when attacked frontally."));
/*     */   
/* 173 */   public final Boostable DEXTERITY = make("DEXTERITY", 5.0D, (Icon)(UI.icons()).s.crossheir, 
/* 174 */       D.g("BATTLE_DEXTERITY", "Dexterity"), 
/* 175 */       D.g("BATTLE_DEXTERITY_D", "Ability to avoid the targets block armour when attacking."));
/*     */   
/* 177 */   public final Boostable PARRY = make("BLOCK", 1.0D, (Icon)(UI.icons()).s.crossheir, 
/* 178 */       D.g("BATTLE_BLOCK", "Block"), 
/* 179 */       D.g("BATTLE_BLOCK_D", "Ability to use the parry attacks and reduce damage with block armour."));
/*     */   
/* 181 */   public final Boostable CHARGE = make("CHARGE", 1.0D, (Icon)(UI.icons()).s.speed, 
/* 182 */       D.g("BATTLE_CHARGE", "Charge"), 
/* 183 */       D.g("BATTLE_CHARGE_D", "Adds extra attack to charge attacks."));
/*     */   
/* 185 */   public final Boostable FORMATION = make("FORMATION_SKILL", 0.0D, (Icon)(UI.icons()).s.muster, 
/* 186 */       D.g("BATTLE_FORMATION_SKILL", "Formation"), 
/* 187 */       D.g("BATTLE_FORMATION_SKILL_D", "Increases defence and parry when in an intact formation and attacked from the front."));
/*     */   
/* 189 */   public final Boostable BLUNT_ATTACK = make("BLUNT_ATTACK", 40.0D, (Icon)(UI.icons()).s.fist, 
/* 190 */       D.g("BATTLE_BLUNT_DAMAGE", "Force"), 
/* 191 */       D.g("BATTLE_BLUNT_DAMAGE_D", "The force of any attack. Force applies damage in itself, but also amplified the attack of other damage types when attacking. Force also creates knock-back that can disrupt enemy formations."));
/*     */   
/* 193 */   public final Boostable BLUNT_DEFENCE = make("BLUNT_DEFENCE", 40.0D, (Icon)(UI.icons()).s.fist, 
/* 194 */       D.g("BATTLE_BLUNT_DEFENCE", "Force Absorbtion"), 
/* 195 */       D.g("BATTLE_BLUNT_DEFENCE_D", "Ability to absorb damage."));
/*     */   
/* 197 */   public final Boostable BLUNT_DEFENCE_DIR = make("BLUNT_DEFENCE_DIR", 1.0D, (Icon)(UI.icons()).s.fist, 
/* 198 */       D.g("BATTLE_BLUNT_DEFENCE_DIR", "Force Block"), 
/* 199 */       D.g("BATTLE_BLUNT_DEFENCE_DIR_D", "Force damage absorbtion when an attack is parried."));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 206 */   public final Boostable MORALE = make("MORALE", 4.0D, (Icon)(UI.icons()).s.standard, 
/* 207 */       D.g("BATTLE_MORALE", "Morale"), 
/* 208 */       D.g("BATTLE_MORALE_D", "A soldier's morale is what determines how long, and against what odds and setbacks, it will fight for before taking flight."));
/*     */   
/*     */   public final LIST<BOOSTABLES.BDamage> DAMAGES;
/*     */   
/*     */   public final RMAP<BOOSTABLES.BDamage> DAMAGE_COLL;
/*     */   
/*     */   Battle() throws IOException {
/* 215 */     super("BATTLE", D.g("Battle"));
/*     */ 
/*     */ 
/*     */     
/* 219 */     PATHS.ResFolder p = PATHS.STATS().folder("damage");
/* 220 */     LinkedList<BOOSTABLES.BDamage> pairs = new LinkedList();
/*     */     
/* 222 */     int index = 0;
/* 223 */     LinkedList<BOOSTABLES.BDamage> da = new LinkedList(); byte b; int i;
/*     */     String[] arrayOfString;
/* 225 */     for (i = (arrayOfString = p.init.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 226 */       BOOSTABLES.BDamage d = new BOOSTABLES.BDamage(index++, this, f, new Json(p.init.gets(f)), new Json(p.text.gets(f)));
/* 227 */       pairs.add(d);
/* 228 */       da.add(d);
/*     */       
/*     */       b++; }
/*     */     
/* 232 */     KeyMap<BOOSTABLES.BDamage> map = new KeyMap();
/* 233 */     for (BOOSTABLES.BDamage pa : pairs) {
/* 234 */       map.put(pa.key, pa);
/*     */     }
/* 236 */     this.DAMAGES = (LIST<BOOSTABLES.BDamage>)new ArrayList((Iterable)pairs);
/*     */     
/* 238 */     this.DAMAGE_COLL = new RMAP("DAMAGE", this.DAMAGES);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BOOSTABLES$Battle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */