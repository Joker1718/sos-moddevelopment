/*     */ package world.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import view.ui.message.MessageText;
/*     */ import world.entity.army.WArmy;
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
/*     */ class null
/*     */   implements ADInit.Updater
/*     */ {
/*     */   public void update(Faction f, double timeSinceLast) {}
/*     */   
/*     */   public void update(WArmy a, double timeSinceLast) {
/* 157 */     if (a.faction() == FACTIONS.player()) {
/* 158 */       double he = ADSupplies.this.health(a);
/* 159 */       for (ADSupply s : all) {
/* 160 */         double am = s.consumedPerDayCurrent(a) * timeSinceLast * TIME.secondsPerDayI();
/* 161 */         int tot = (int)am;
/* 162 */         if (am - tot > RND.rFloat())
/* 163 */           tot++; 
/* 164 */         s.current().inc(a, -tot);
/*     */       } 
/*     */       
/* 167 */       if (he >= 1.0D && AD.supplies().health(a) < 1.0D) {
/* 168 */         Str.TMP.clear();
/* 169 */         Str.TMP.add(ADSupplies.¤¤StarvingD).insert(0, (CharSequence)a.name);
/* 170 */         (new MessageText(ADSupplies.¤¤Starving, (CharSequence)Str.TMP)).send();
/*     */       } 
/*     */     } else {
/* 173 */       for (ADSupply s : (AD.supplies()).all) {
/* 174 */         double am = Math.ceil(s.targetAmount(a) / 16.0D);
/* 175 */         double tar = s.minimumAmount(a);
/* 176 */         am += s.current().get(a);
/* 177 */         if (am > tar)
/* 178 */           am = tar; 
/* 179 */         s.current().set(a, (int)am);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupplies$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */