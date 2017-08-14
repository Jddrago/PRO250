/* This file is part of VeinMiner.
 *
 *    VeinMiner is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as
 *    published by the Free Software Foundation, either version 3 of
 *     the License, or (at your option) any later version.
 *
 *    VeinMiner is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with VeinMiner.
 *    If not, see <http://www.gnu.org/licenses/>.
 */

package portablejim.veinminer.util;

/**
 * Simple enum to provide easy reading of the client preferred modes.
 *
 * Outside another class as it is used by multiple classes.
 */

public class PreferredMode {
    public static final int DISABLED = 0;
    public static final int PRESSED = 1;
    public static final int RELEASED = 2;
    public static final int SNEAK_ACTIVE = 3;
    public static final int SNEAK_INACTIVE = 4;

    public static int length() {
        return 5;
    }
}
